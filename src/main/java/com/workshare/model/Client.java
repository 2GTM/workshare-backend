package com.workshare.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client extends WorkShareTable {

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;
}
