package com.workshare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vote extends WorkShareTable {

    @OneToOne
    private Client client;

    @ManyToOne
    private Project project;
}
