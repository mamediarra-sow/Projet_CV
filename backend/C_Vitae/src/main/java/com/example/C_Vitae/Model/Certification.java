package com.example.C_Vitae.Model;

import javax.persistence.*;

@Entity
@Table(name = "CERTIFICATION")
public class Certification {
    @Id
    @SequenceGenerator(
            name = "certification_sequence",
            sequenceName = "certification_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "certification_sequence"
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "personne_id",nullable = false)
    private Personne personne;
    private String date;
    private String lien_certificat;
    /////////////////Constructeur//////////////////

    public Certification() {
    }

    public Certification(Integer id, String date, String lien_certificat) {
        this.id = id;
        this.date = date;
        this.lien_certificat = lien_certificat;
    }
    ///////////////////Getter et Setter//////////////

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLien_certificat() {
        return lien_certificat;
    }

    public void setLien_certificat(String lien_certificat) {
        this.lien_certificat = lien_certificat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
