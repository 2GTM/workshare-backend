package com.workshare.repository;

import com.workshare.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "SELECT TOP 10 FROM project ORDER BY votes", nativeQuery = true)
    Set<Project> findTrendingProjects();
}
