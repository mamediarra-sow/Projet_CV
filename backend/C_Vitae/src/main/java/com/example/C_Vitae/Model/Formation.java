package com.example.C_Vitae.Model;

import javax.persistence.*;

@Entity
@Table (name = "FORMATION")
public class Formation {
    @Id
    @SequenceGenerator(
            name = "formation_sequence",
            sequenceName = "formation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "formation_sequence"
    )
    private Integer id;

    private String date;

    private String description;

    @ManyToOne
    @JoinColumn(name="personne_id",nullable = false)
    private Personne personne;

    /////////////////////////Constructeur//////////////////////////////


    public Formation() {
    }

    public Formation(String date, String description) {
        this.date = date;
        this.description = description;
    }
    ///////////////////////Getter and Setter///////////////////////////


    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //////////////////////////

}


