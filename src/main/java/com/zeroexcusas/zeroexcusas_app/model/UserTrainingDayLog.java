package com.zeroexcusas.zeroexcusas_app.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "usertrainingdaylog", schema = "public" )
@Data
public class UserTrainingDayLog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    @NotNull
    private int id;

    @Column( name = "datecreated" )
    @NotNull
    private LocalDateTime datecreated;

    @Column( name = "completed" )
    @NotNull
    private boolean completed;

    @ManyToOne
    @JoinColumn( name = "fk_trainingday" )
    private TrainingDay _trainingDay;

    @ManyToOne
    @JoinColumn( name = "fk_user" )
    private User _user;
}
