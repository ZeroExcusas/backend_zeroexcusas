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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "trainingplace", schema = "public" )
@Data
public class TrainingPlace
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany( mappedBy = "_trainingPlace", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<User> _userList;

    @OneToMany( mappedBy = "_trainingPlace", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Program> _programList;
}
