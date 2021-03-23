package com.example.C_Vitae.Service;

import com.example.C_Vitae.DAO.DAO_Competence;
import com.example.C_Vitae.Formulaire.CompRequest;
import com.example.C_Vitae.Model.Competence;
import com.example.C_Vitae.Model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompService {
    private final DAO_Competence COMP;
    @Autowired
    public CompService(DAO_Competence comp) {
        COMP = comp;
    }
    public List<Competence> getCompétences(){return COMP.findAll();}
    public List<Competence> getCompetencesByPersonne(int id){
        return COMP.findCompetencesByPersonne(id);}
    public void SaveComp(CompRequest request, Personne personne){
        Competence comp = new Competence(request.getDomaine(), request.getLibelle());
        comp.setPersonne(personne);
        COMP.save(comp);
    }
}
