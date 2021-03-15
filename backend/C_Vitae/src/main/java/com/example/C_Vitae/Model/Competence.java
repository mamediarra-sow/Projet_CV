package com.example.C_Vitae.Model;

import javax.persistence.*;

@Entity
@Table(name = "COMPETENCE")
public class Competence {
    @Id
    @SequenceGenerator(
            name = "competence_sequence",
            sequenceName = "competence_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "competence_sequence"
    )
    private int id;

    @ManyToOne
    @JoinColumn(name = "personne_id",nullable = false)
    private Personne personne;

    private String domaine;

    private String libelle;
    ///////////////// Constructeur///////////////////

    public Competence(int id,String domaine, String libelle) {
        this.id = id;
        this.domaine = domaine;
        this.libelle = libelle;
    }
    ///////////////Getter et Setter////////////////////


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
