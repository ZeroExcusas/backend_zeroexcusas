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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "meal", schema = "public" )
@Data
public class Meal
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "datecreated")
    @NotNull
    private LocalDateTime datecreated;

    @Column(name = "datemodified")
    private LocalDateTime datemodified;

    @Column(name = "completed")
    private boolean completed;

    @Column(name = "deleted")
    @NotNull
    private boolean deleted;

    @Column(name = "waterconsumed")
    @NotNull
    private BigDecimal waterconsumed;

    @Column(name = "calories")
    @NotNull
    private BigDecimal calories;

    @ManyToOne
    @JoinColumn( name = "fk_mealbuilder" )
    private MealBuilder _mealBuilder;

    @OneToMany( mappedBy = "_meal", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<MealUnit> _mealUnitList;
}
