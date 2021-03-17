package com.example.C_Vitae.Model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Entity
@Table(name = "EXPERIENCE")
public class Experience {
    @Id
    @SequenceGenerator(
            name = "experience_sequence",
            sequenceName = "experience_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "experience_sequence"
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "personne_id",nullable = false)
    private Personne personne;

    private String date;
    private String description;
    @ElementCollection
    private List <String> technologies;
    //////////////////////////Constructeur///////////////////////////

    public Experience() {
    }

    public Experience(Integer id, String date, String description, List<String> technologies) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.technologies = technologies;
    }
    ////////////////////////////Getter et Setter////////////////////////

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

    public List<String> getTechnoogies() {
        return technologies;
    }

    public void setTechnoogies(List<String> technoogies) {
        this.technologies = technoogies;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}
