package com.zeroexcusas.zeroexcusas_app.model;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "unit", schema = "public" )
@Data @NoArgsConstructor
public class Unit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column(name = "value")
    @NotNull
    private BigDecimal value;

    /*
    @Column(name = "type")
    @NotNull
    private String type;
    */

    @Column(name = "date")
    @NotNull
    private LocalDateTime date;

    /*
    @Column(name = "systemname")
    @NotNull
    private String systemname;

    @Column(name = "systemunit")
    @NotNull
    private String systemunit;
    */

    @OneToOne
    private BodyMeasure _bodyMeasure;



    @ManyToOne
    @JoinColumn( name = "fk_user" )
    private User _user;

    @ManyToOne
    @JoinColumn( name = "fk_progress" )
    private Progress _progress;
}
