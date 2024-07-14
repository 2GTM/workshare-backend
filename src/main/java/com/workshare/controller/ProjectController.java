package com.workshare.controller;

import com.workshare.dto.ProjectViewDto;
import com.workshare.model.Project;
import com.workshare.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@CrossOrigin("http://localhost")
@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/search")
    public ResponseEntity<Set<ProjectViewDto>> search(
        @RequestParam(required = false, defaultValue = "") String content,
        @RequestParam(required = false, defaultValue = "") Set<String> tags
    ) {
        return ResponseEntity.ok(projectService.searchProjects(content, tags));
    }

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

    @PostMapping("/{projectId}/addMember")
    public ResponseEntity<ProjectViewDto> addMemberToProject(@PathVariable long projectId, @RequestParam String clientName) {
        return ResponseEntity.ok(projectService.addMemberToProject(projectId, clientName));
    }

    // NOT WORKING YET - DO AT THE END
    @PostMapping("/{projectId}/vote")
    public ResponseEntity<ProjectViewDto> voteProject(@PathVariable long projectId, @RequestParam String clientName) {
        return ResponseEntity.ok(projectService.voteProject(projectId,clientName));
    }

    @PatchMapping("/{projectId}")
    public ResponseEntity<ProjectViewDto> updateProject(@RequestBody ProjectViewDto dto, @PathVariable long projectId) {
        return ResponseEntity.ok(projectService.createOrUpdateProject(dto, projectId));
    }
}
