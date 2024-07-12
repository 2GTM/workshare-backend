package com.workshare.service;

import com.workshare.dto.ProjectViewDto;
import com.workshare.exception.type.ProjectNotFound;
import com.workshare.model.Client;
import com.workshare.model.Project;
import com.workshare.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ClientService clientService;

    public ProjectViewDto getProjectWithId(long projectId) {
        return ProjectViewDto.from(projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFound::new));
    }

    private Set<String> getAllMembersUsernames(Project project) {
        return project.getMembers()
                .stream()
                .map(Client::getUsername)
                .collect(Collectors.toSet());
    }

    private Set<Client> getAllMembers(Set<String> membersUsername) {
        return membersUsername
                .stream()
                .map(clientService::getClientByUsername)
                .collect(Collectors.toSet());
    }

    public ProjectViewDto createProject(ProjectViewDto dto) {
        return ProjectViewDto.from(projectRepository.save(Project
                .builder()
                    .title(dto.title())
                    .description(dto.description())
                    .client(clientService.getClientByUsername(dto.nameOfPublisher()))
                    .members(this.getAllMembers(dto.membersUsername()))
                .build()));


    }
}
