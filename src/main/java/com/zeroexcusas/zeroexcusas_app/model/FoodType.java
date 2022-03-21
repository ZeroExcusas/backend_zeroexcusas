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
@Table(name = "foodtype", schema = "public" )
@Data
public class FoodType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "datecreated")
    @NotNull
    private LocalDateTime datecreated;

    @Column(name = "datemodified")
    private LocalDateTime datemodified;

    @Column(name = "value")
    @NotNull
    private BigDecimal value;

    @Column(name = "proteinperunitgram")
    private BigDecimal proteinperunitgram;

    @Column(name = "carbsperunitgram")
    private BigDecimal carbsperunitgram;

    @Column(name = "fatperunitgram")
    private BigDecimal fatperunitgram;

    @Column(name = "deleted")
    @NotNull
    private boolean deleted;

    @ManyToOne
    @JoinColumn( name = "fk_basicunit" )
    private BasicUnit _basicUnit;

    @ManyToOne
    @JoinColumn( name = "fk_nutrientclass" )
    private NutrientClass _nutrientClass;

    @OneToMany( mappedBy = "_foodType", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<MealUnit> _mealUnitList;

    @OneToMany( mappedBy = "_foodType", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Allergy> _allergyList;
}
