package com.workshare.controller;

import com.workshare.dto.ProjectViewDto;
import com.workshare.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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
        return ResponseEntity.ok(projectService.getProjectWithId(projectId));
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectViewDto> createProject(ProjectViewDto dto) {
        return ResponseEntity.ok(projectService.createProject(dto));
    }
}
