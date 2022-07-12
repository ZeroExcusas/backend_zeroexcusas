package com.zeroexcusas.zeroexcusas_app.testing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "editorial", schema = "public" )
@Data
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    private String name;
    private int creationDate;

    //@JsonIgnore
    @OneToOne
    private Author author;

}
