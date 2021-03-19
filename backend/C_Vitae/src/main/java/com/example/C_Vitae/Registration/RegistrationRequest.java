package com.example.C_Vitae.Registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest {
    private String nom;
    private String prenom;
    private String date_naissance;
    private String adresse;
    private String email;
    private String situation_matrimoniale;
    private String username;
    private String password;
    private List<String> Langues;
    private List<String> Loisirs;
    private List<String> vie_assoc;
}
