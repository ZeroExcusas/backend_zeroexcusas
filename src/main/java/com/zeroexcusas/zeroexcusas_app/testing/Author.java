package com.zeroexcusas.zeroexcusas_app.testing;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "author", schema = "public" )
@Data
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;

    private String name;
    private String email;
    private String phoneNumber;

//    @OneToOne
 //   private Editorial editorial;

}
