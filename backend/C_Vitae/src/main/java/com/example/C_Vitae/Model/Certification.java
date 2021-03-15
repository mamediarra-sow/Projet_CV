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
    private int id;

    @ManyToOne
    @JoinColumn(name = "personne_id",nullable = false)
    private Personne personne;
    private String date;
    private String lien_certificat;
    /////////////////Constructeur//////////////////

    public Certification(int id, String date, String lien_certificat) {
        this.id = id;
        this.date = date;
        this.lien_certificat = lien_certificat;
    }
    ///////////////////Getter et Setter//////////////

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
    /////////////////
    public String toString(){
        return ("Cette certification a été obtenue le "+this.date+" vous pouvez trouver le justificatif en cliquant  "+this.lien_certificat);
    }
}
