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

@Entity
@Table(name = "allergy", schema = "public" )
@Data
public class Allergy
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(name = "name")
    private String description;

    @Column(name = "deleted")
    @NotNull
    private boolean deleted;

    @ManyToOne
    @JoinColumn( name = "fk_user" )
    private User _user;

    @ManyToOne
    @JoinColumn( name = "fk_foodtype" )
    private FoodType _foodType;
}
