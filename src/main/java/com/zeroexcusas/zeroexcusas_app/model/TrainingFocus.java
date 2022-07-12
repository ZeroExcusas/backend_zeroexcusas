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
import java.util.List;

@Entity
@Table(name = "trainingfocus", schema = "public" )
@Data
public class TrainingFocus
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
    @NotNull
    private String description;
    @OneToMany( mappedBy = "_trainingFocus", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<User> _userList;

    @OneToMany( mappedBy = "_trainingFocus", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Exercise> _exerciseList;

    @OneToMany( mappedBy = "_trainingFocus", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Program> _programList;
}
