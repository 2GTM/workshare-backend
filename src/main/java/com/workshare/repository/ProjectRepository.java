package com.workshare.repository;

import com.workshare.dto.ProjectViewDto;
import com.workshare.model.Client;
import com.workshare.model.Project;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query(value = "SELECT c.username from project p, rel_project_member rpm, client c WHERE p.id = ?1 AND p.id = rpm.project_id AND c.id = rpm.member_id", nativeQuery = true)
    Set<String> findMembersUsernamesById(long id);

    @Query(value = "SELECT * FROM project ORDER BY vote_count DESC LIMIT 5", nativeQuery = true)
    Set<Project> findTrendingProjects();

    @Query("SELECT new com.workshare.dto.ProjectViewDto(p) FROM Project p WHERE LOWER(p.title) LIKE %?1% OR LOWER(p.description) LIKE %?1%")
    Set<ProjectViewDto> searchProjects(String content, Sort sort);

    @Query("SELECT new com.workshare.dto.ProjectViewDto(p) FROM Project p")
    Set<ProjectViewDto> getAll(Sort sort);

    @Query("SELECT new com.workshare.dto.ProjectViewDto(p) FROM Project p WHERE p.client.id = ?1")
    Set<ProjectViewDto> findAllByClient(long clientId);
}