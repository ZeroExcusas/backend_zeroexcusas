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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "trainingday", schema = "public" )
@Data
public class TrainingDay
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "datecreated")
    @NotNull
    private LocalDateTime datecreated;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "deleted")
    @NotNull
    private boolean deleted;

    @OneToMany( mappedBy = "_trainingDay", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<WeekTrainingDay> _weekTrainingDayList;

    @OneToMany( mappedBy = "_trainingDay", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<TrainingDayExercise> _trainingDayExerciseList;

    @OneToMany( mappedBy = "_trainingDay", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<UserTrainingDayLog> _userTrainingDayLogList;

    @OneToMany( mappedBy = "_trainingDay", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Comments> _commentsList;
}
