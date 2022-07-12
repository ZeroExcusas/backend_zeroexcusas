package com.zeroexcusas.zeroexcusas_app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "user", schema = "public" )
@Data @NoArgsConstructor
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    @NotNull
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private int id;

    @Column( name = "first_name" )
    @NotNull
    private String firstname;

    @Column( name = "last_name" )
    @NotNull
    private String lastname;

    @Column( name = "datecreated" )
    @NotNull
    private LocalDateTime datecreated;

    @Column( name = "username" )
    @NotNull
    private String username;


    @Column( name = "email" )
    @NotNull
    private String email;

    @Column( name = "password" )
    @NotNull
    private String password;

    @Column( name = "profileimage" )
    private String profileimage;

    @Column( name = "phone" )
    private String phone;

    @Column( name = "birthday" )
    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

    @Column( name = "biography" )
    @NotNull
    private String biography;

    @Column( name = "dateleft" )
    private LocalDateTime dateleft;

    @Column( name = "devicetoken" )
    private String devicetoken;

    @Column( name = "subscribed" )
    private boolean subscribed;

    @Column( name = "phoneverified" )
    private boolean phoneverified;

    @Column( name = "calories" )
    private BigDecimal calories;

    @Column( name = "bmr" )
    private BigDecimal bmr;

    @Column( name = "bmractivity" )
    private BigDecimal bmractivity;

    @Column( name = "macroprotein" )
    private BigDecimal macroprotein;

    @Column( name = "macrofat" )
    private BigDecimal macrofat;

    @Column( name = "macrocarbohydrate" )
    private BigDecimal macrocarbohydrate;

    @Column( name = "trainingdays" )
    private int trainingdays;

    @Column( name = "trainingduration" )
    private int trainingduration;

    @ManyToOne
    @JoinColumn( name = "fk_gender" )
    private Gender _gender;

    @ManyToOne
    @JoinColumn( name = "fk_country" )
    private Country _country;

    @ManyToOne
    @JoinColumn( name = "fk_goal" )
    private Goal _goal;

    @ManyToOne
    @JoinColumn( name = "fk_activitylevel" )
    private ActivityLevel _activityLevel;

    @ManyToOne
    @JoinColumn( name = "fk_traininglevel" )
    private TrainingLevel _trainingLevel;

    @ManyToOne
    @JoinColumn( name = "fk_trainingplace" )
    private TrainingPlace _trainingPlace;

    @ManyToOne
    @JoinColumn( name = "fk_trainingfocus" )
    private TrainingFocus _trainingFocus;

    @OneToMany( mappedBy = "_user", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Notification> _notificationList;

    @OneToMany( mappedBy = "_user", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Invitation> _invitationList;

    @OneToMany( mappedBy = "_user", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Suggestion> _suggestionList;

    @OneToMany( mappedBy = "_user", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Progress> _progressList;

    @OneToMany( mappedBy = "_user", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Unit> _unitList;

    @OneToMany( mappedBy = "_user", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Allergy> _allergyList;

    @OneToMany( mappedBy = "_user", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<MealBuilder> _mealBuilderList;

    @OneToMany( mappedBy = "_user", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Score> _scoreList;

    @OneToMany( mappedBy = "_user", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<UserProgramLog> _userProgramLogList;

    @OneToMany( mappedBy = "_user", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<TrainingDayLog> _trainingDayLogList;


    @OneToMany( mappedBy = "_user", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<Comments> _commentsList;


    @OneToMany( mappedBy = "_user", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    private List<UserTrainingDayLog> _userTrainingDayLogList;

}
