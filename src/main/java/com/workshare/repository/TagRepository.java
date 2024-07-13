package com.workshare.repository;

import com.workshare.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>  {
    Optional<Tag> findOneByContent(String content);
}
