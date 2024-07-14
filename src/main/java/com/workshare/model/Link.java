package com.workshare.model;

import com.workshare.enums.LinkVisibility;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Link extends WorkShareTable {
    @NotBlank
    private String content;

    @ColumnDefault("0")
    @Builder.Default
    private LinkVisibility visibility = LinkVisibility.PUBLIC;
}
