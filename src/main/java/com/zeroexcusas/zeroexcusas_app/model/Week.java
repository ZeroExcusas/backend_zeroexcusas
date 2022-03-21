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
@Table(name = "week", schema = "public" )
@Data
public class Week
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    @NotNull
    private int id;

    @Column( name = "datecreated" )
    @NotNull
    private LocalDateTime datecreated;

    @Column( name = "description" )
    private String description;

    @Column( name = "deleted" )
    @NotNull
    private boolean deleted;

    @ManyToOne
    @JoinColumn( name = "fk_program" )
    private Program _program;

    @OneToMany( mappedBy = "_week", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<WeekTrainingDay> _weekTrainingDayList;
}
