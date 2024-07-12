package com.workshare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Set;

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
            name = "projectMembers",
            inverseJoinColumns = @JoinColumn(name = "member_id"))
    private Set<Client> members;
}
