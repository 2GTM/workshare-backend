package com.workshare.service;

import com.workshare.dto.ProjectViewDto;
import com.workshare.exceptions.type.ClientNotFound;
import com.workshare.exceptions.type.ProjectNotFound;
import com.workshare.model.Client;
import com.workshare.model.Link;
import com.workshare.model.Project;
import com.workshare.repository.ClientRepository;
import com.workshare.repository.LinkRepository;
import com.workshare.repository.ProjectRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Validated
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ClientService clientService;
    private final LinkRepository linkRepository;

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

    public ProjectViewDto createOrUpdateProject(@Valid ProjectViewDto dto, Long projectId) {
        boolean isUpdate = projectId != null;
        Project project = isUpdate ? projectRepository.findById(projectId).orElseThrow(ProjectNotFound::new) : new Project();

        project.setTitle(dto.title());
        project.setDescription(dto.description());
        project.setMembers(this.getAllMembersFromUsernames(dto.membersUsername()));

        System.out.println(dto.linksContent());
        project.setLinks(
            dto.linksContent().stream()
                .map(e -> linkRepository.save(Link.builder().content(e).build()))
                .collect(Collectors.toSet())
        );

        if(!isUpdate) {
            project.setClient(clientRepository.findByUsername(dto.publisherName()).orElseThrow(ClientNotFound::new));
        }

        return ProjectViewDto.from(projectRepository.save(project));
    }
}
