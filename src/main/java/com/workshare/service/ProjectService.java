package com.workshare.service;

import com.workshare.dto.ProjectViewDto;
import com.workshare.exceptions.type.ClientNotFound;
import com.workshare.exceptions.type.ProjectNotFound;
import com.workshare.model.Client;
import com.workshare.model.Project;
import com.workshare.repository.ClientRepository;
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

    public Set<ProjectViewDto> getTrendingProjects() {
        return projectRepository.findTrendingProjects()
                .stream()
                .map(ProjectViewDto::from)
                .collect(Collectors.toSet());
    }
    private final ClientRepository clientRepository;

    public ProjectViewDto getProjectWithId(long projectId) {
        return ProjectViewDto.from(projectRepository.findById(projectId)
                .orElseThrow(ProjectNotFound::new));
    }

    // Tested. Should work.
    public Set<String> getAllMembersUsernamesFromProjectId(long projectId) {
        return projectRepository.findMembersUsernamesById(projectId);
    }

    private Set<Client> getAllMembersFromUsernames(Set<String> usernames) {
        return usernames
                .stream()
                .map(clientService::getClientByUsername)
                .collect(Collectors.toSet());
    }

    public ProjectViewDto createProject(ProjectViewDto dto) {
        return ProjectViewDto.from(projectRepository.save(Project
                .builder()
                    .title(dto.title())
                    .description(dto.description())
                    .votes(dto.votes())
                    .client(clientService.getClientByUsername(dto.publisherName()))
                    .members(this.getAllMembersFromUsernames(dto.memberUsernames()))
                .build()));
    }

    public void createOrUpdateProject(ProjectViewDto dto) {
        boolean isUpdate = dto.id() != null;
        Project project = isUpdate ? projectRepository.findById(dto.id()).orElseThrow(ProjectNotFound::new) : new Project();

        project.setTitle(dto.title());
        project.setDescription(dto.description());
        project.setMembers(this.getAllMembersFromUsernames(dto.memberUsernames()));
        //project.setLinks();

        if(!isUpdate) {
            project.setClient(clientRepository.findByUsername(dto.publisherName()).orElseThrow(ClientNotFound::new));
        }
    }
}
