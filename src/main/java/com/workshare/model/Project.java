package com.workshare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.List;
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

    private int votes;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "rel_project_member",
            inverseJoinColumns = @JoinColumn(name = "member_id"))
    private Set<Client> members;

    @ManyToMany
    @JoinTable(
        name = "rel_project_links",
        inverseJoinColumns = @JoinColumn(name = "link_id")
    )
    private Set<Link> links = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "rel_project_tag",
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();
}
