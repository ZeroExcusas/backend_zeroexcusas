package com.zeroexcusas.zeroexcusas_app.model;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "level", schema = "public" )
@Data
public class Level
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    @NotNull
    private LocalDateTime date;

    @Column(name = "points")
    @NotNull
    private int points;

    @OneToMany( mappedBy = "_level", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<LevelObjective> _levelObjectiveList;
}
