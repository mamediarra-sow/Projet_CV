package com.example.C_Vitae.Model;

import javassist.Loader;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Entity
@Table(name = "PERSONNE")
public class Personne implements UserDetails {
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
    private Integer id;

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
    private String username;
    private String password;
    @ElementCollection
    private List<String> Langues;

    @ElementCollection
    private List<String> Loisirs;

    @ElementCollection
    private List<String> vie_assoc;
    @Enumerated(EnumType.STRING)
    private AppUserRole role;
    private Boolean locked = false;
    private Boolean enabled = false;

    /////////////////////// Constructeur///////////////////////////////


    public Personne() {
    }

    public Personne(String username,String password,String nom, String prenom, String date_naissance, String adresse, String email,
                    String situation_matrimoniale, List<String> langues, List<String> loisirs, List<String> vie_assoc,AppUserRole role) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.email = email;
        this.situation_matrimoniale = situation_matrimoniale;
        Langues = langues;
        Loisirs = loisirs;
        this.vie_assoc = vie_assoc;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    ///////////////////////Getter et Setter/////////////////////////////////


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public AppUserRole getRole() {
        return role;
    }

    public void setRole(AppUserRole role) {
        this.role = role;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

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
    ///////////////////////UserDetails methods/////////////////////////

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
