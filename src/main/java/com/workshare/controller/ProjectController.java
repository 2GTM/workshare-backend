package com.workshare.controller;

import com.workshare.dto.ProjectViewDto;
import com.workshare.dto.VoteProjectDto;
import com.workshare.model.Project;
import com.workshare.service.ProjectService;
import jakarta.validation.Valid;
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
    public ResponseEntity<ProjectViewDto> createProject(@RequestBody ProjectViewDto dto) {
        return ResponseEntity.ok(projectService.createOrUpdateProject(dto, null));
    }

    // NOT WORKING YET - DO AT THE END
    @PostMapping("/vote")
    public ResponseEntity<Project> voteProject(VoteProjectDto dto) {
        return ResponseEntity.ok(projectService.voteProject(dto));
    }

    @PatchMapping("/{projectId}")
    public ResponseEntity<ProjectViewDto> updateProject(@RequestBody ProjectViewDto dto, @PathVariable long projectId) {
        return ResponseEntity.ok(projectService.createOrUpdateProject(dto, projectId));
    }
}
