package com.zeroexcusas.zeroexcusas_app.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "exercise", schema = "public" )
@Data
public class Exercise
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "url")
    @NotNull
    private String url;

    @Column(name = "date")
    @NotNull
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn( name = "fk_trainingfocus" )
    private TrainingFocus _trainingFocus;

    @OneToMany( mappedBy = "_exercise", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<TrainingDayExercise> _trainingDayExerciseList;
}
