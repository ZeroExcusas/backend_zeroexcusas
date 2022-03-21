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
@Table(name = "invitation", schema = "public" )
@Data
public class Invitation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "date")
    @NotNull
    private LocalDateTime date;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn( name = "fk_user" )
    private User _user;
}
