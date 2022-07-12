package com.zeroexcusas.zeroexcusas_app.model;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name = "weektrainingday", schema = "public" )
@Data
public class WeekTrainingDay
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    @NotNull
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(name = "datecreated")
    @NotNull
    private LocalDateTime datecreated;

    @Column( name = "description" )
    @NotNull
    private String description;

    @Column( name = "day" )
    @NotNull
    private String day;

    @ManyToOne
    @JoinColumn( name = "fk_week" )
    private Week _week;

    @ManyToOne
    @JoinColumn( name = "fk_trainingday")
    private TrainingDay _trainingDay;



}
