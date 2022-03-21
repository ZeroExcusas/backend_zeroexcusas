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
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "mealunit", schema = "public" )
@Data
public class MealUnit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "amount")
    @NotNull
    private BigDecimal amount;

    @Column(name = "date")
    @NotNull
    private LocalDateTime date;

    @Column(name = "deleted")
    @NotNull
    private boolean deleted;

    @ManyToOne
    @JoinColumn( name = "fk_meal" )
    private Meal _meal;

    @ManyToOne
    @JoinColumn( name = "fk_foodtype" )
    private FoodType _foodType;
}
