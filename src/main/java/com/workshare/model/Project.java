package com.workshare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project extends WorkShareTable {
    @NotNull
    private String title;

    @NotNull
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "rel_project_member",
            inverseJoinColumns = @JoinColumn(name = "member_id"))
    private Set<Client> members;

    @OneToMany
    @JoinColumn(name = "project_id")
    private Set<Link> links;

    private int voteCount;

    @ManyToMany
    @JoinTable(
        name = "rel_project_tag",
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    @OneToMany(mappedBy = "project")
    private Set<Vote> votes;

    @Builder.Default
    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT NOW()")
    private LocalDateTime creationDate = LocalDateTime.now();

    @Builder.Default
    @Column(nullable = false, columnDefinition = "DATETIME DEFAULT NOW()")
    private LocalDateTime lastModifiedDate = LocalDateTime.now();
}
