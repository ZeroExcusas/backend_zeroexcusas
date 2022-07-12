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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "program", schema = "public" )
@Data
public class Program
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(name = "datecreated")
    @NotNull
    private LocalDateTime datecreated;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "days")
    @NotNull
    private int days;

    @Column(name = "weeks")
    @NotNull
    private int weeks;

    @Column(name = "deleted")
    @NotNull
    private boolean deleted;

    @ManyToOne
    @JoinColumn( name = "fk_trainingplace" )
    private TrainingPlace _trainingPlace;

    @ManyToOne
    @JoinColumn( name = "fk_trainingfocus" )
    private TrainingFocus _trainingFocus;

    @ManyToOne
    @JoinColumn( name = "fk_traininglevel" )
    private TrainingLevel _trainingLevel;

    @OneToMany( mappedBy = "_program", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Week> _weekList;

    @OneToMany( mappedBy = "_program", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<UserProgramLog> _userProgramLogList;
}
