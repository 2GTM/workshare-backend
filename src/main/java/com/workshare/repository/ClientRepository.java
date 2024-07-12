package com.workshare.repository;

import com.workshare.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByUsername(String username);

    @Query(value = "SELECT c.username FROM client c", nativeQuery = true)
    Set<String> findAllUsernames();
}
