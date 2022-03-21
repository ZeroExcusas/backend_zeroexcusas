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
@Table(name = "unit", schema = "public" )
@Data
public class Unit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "value")
    @NotNull
    private BigDecimal value;

    @Column(name = "type")
    @NotNull
    private String type;

    @Column(name = "date")
    @NotNull
    private LocalDateTime date;

    @Column(name = "systemunit")
    @NotNull
    private String systemunit;

    @ManyToOne
    @JoinColumn( name = "fk_user" )
    private User _user;

    @ManyToOne
    @JoinColumn( name = "fk_progress" )
    private Progress _progress;
}
