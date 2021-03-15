package com.example.C_Vitae.Model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "PERSONNE")
public class Personne {
    @Id
    @SequenceGenerator(
            name = "personne_sequence",
            sequenceName = "personne_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "personne_sequence"
    )
    private int id;

    @OneToMany(mappedBy = "personne")
    private List<Formation> formations;

    @OneToMany(mappedBy = "personne")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "personne")
    private List<Certification> certifications;

    @OneToMany(mappedBy = "personne")
    private List<Competence> competences;

    private String nom;
    private String prenom;
    private String date_naissance;
    private String adresse;
    private String email;
    private String situation_matrimoniale;

    @ElementCollection
    private List<String> Langues;

    @ElementCollection
    private List<String> Loisirs;

    @ElementCollection
    private List<String> vie_assoc;

    /////////////////////// Constructeur///////////////////////////////


    public Personne(int id, String nom, String prenom, String date_naissance, String adresse, String email,
                    String situation_matrimoniale, List<String> langues, List<String> loisirs, List<String> vie_assoc) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.email = email;
        this.situation_matrimoniale = situation_matrimoniale;
        Langues = langues;
        Loisirs = loisirs;
        this.vie_assoc = vie_assoc;
    }
    ///////////////////////Getter et Setter/////////////////////////////////


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSituation_matrimoniale() {
        return situation_matrimoniale;
    }

    public void setSituation_matrimoniale(String situation_matrimoniale) {
        this.situation_matrimoniale = situation_matrimoniale;
    }

    public List<String> getLangues() {
        return Langues;
    }

    public void setLangues(List<String> langues) {
        Langues = langues;
    }

    public List<String> getLoisirs() {
        return Loisirs;
    }

    public void setLoisirs(List<String> loisirs) {
        Loisirs = loisirs;
    }

    public List<String> getVie_assoc() {
        return vie_assoc;
    }

    public void setVie_assoc(List<String> vie_assoc) {
        this.vie_assoc = vie_assoc;
    }
}
