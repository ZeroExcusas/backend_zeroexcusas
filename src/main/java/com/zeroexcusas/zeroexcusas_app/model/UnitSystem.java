package com.zeroexcusas.zeroexcusas_app.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data @NoArgsConstructor
@Table(name = "unitsystem", schema = "public")
public class UnitSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    @Column(name = "name")
    @NotNull
    private String name;

    // This a comment
}
