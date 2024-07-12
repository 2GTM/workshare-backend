package com.workshare.controller;

import com.workshare.dto.ProjectViewDto;
import com.workshare.dto.VoteProjectDto;
import com.workshare.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@CrossOrigin("${ALLOWED_URL}")
@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/trend")
    public ResponseEntity<Set<ProjectViewDto>> getTrends() {
        return ResponseEntity.ok(projectService.getTrendingProjects());
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectViewDto> getProjectById(@PathVariable long projectId) {
        return ResponseEntity.ok(projectService.getProjectViewWithId(projectId));
    }

    @PostMapping
    public ResponseEntity<ProjectViewDto> createProject(ProjectViewDto dto) {
        return ResponseEntity.ok(projectService.createOrUpdateProject(dto, null));
    }

    @PatchMapping("/{projectId}")
    public ResponseEntity<ProjectViewDto> updateProject(ProjectViewDto dto, @PathVariable long projectId) {
        return ResponseEntity.ok(projectService.createOrUpdateProject(dto, projectId));
    }


}
