package com.workshare.repository;

import com.workshare.dto.ProjectViewDto;
import com.workshare.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectPaginationRepo extends JpaRepository<Project, Long> {
    @Query("SELECT new com.workshare.dto.ProjectViewDto(p) FROM Project p WHERE ?1 = '' OR (LOWER(p.title) LIKE %?1% OR LOWER(p.description) LIKE %?1%)")
    Page<ProjectViewDto> searchProjectsByContent(String content, Pageable pageable);

    @Query("SELECT new com.workshare.dto.ProjectViewDto(p) FROM Project p")
    Page<ProjectViewDto> getAll(Pageable pageable);
}
