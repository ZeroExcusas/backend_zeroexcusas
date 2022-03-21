package com.zeroexcusas.zeroexcusas_app.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gender", schema = "public" )
@Data
public class Gender
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @OneToMany( mappedBy = "_gender", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<User> _userList;
}
