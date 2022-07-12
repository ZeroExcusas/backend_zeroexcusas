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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "mealbuilder", schema = "public" )
@Data
public class MealBuilder
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

    @Column(name = "datemodified")
    private LocalDateTime datemodified;

    @Column(name = "dateschedule")
    private LocalDateTime dateschedule;

    @Column(name = "numberofmeals")
    @NotNull
    private int numberofmeals;

    @Column(name = "completed")
    private boolean completed;

    @Column(name = "editable")
    private boolean editable;

    @Column(name = "calories")
    @NotNull
    private BigDecimal calories;

    @Column(name = "waterconsumed")
    @NotNull
    private BigDecimal waterconsumed;

    @ManyToOne
    @JoinColumn( name = "fk_user" )
    private User _user;

    @OneToMany( mappedBy = "_mealBuilder", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Meal> _mealList;
}
