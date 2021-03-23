package com.example.C_Vitae.Service;

import com.example.C_Vitae.DAO.DAO_Experience;
import com.example.C_Vitae.Formulaire.ExpRequest;
import com.example.C_Vitae.Model.Experience;
import com.example.C_Vitae.Model.Personne;
import org.hibernate.query.criteria.internal.compile.ExplicitParameterInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpService {
    private final DAO_Experience EXP;
    @Autowired
    public ExpService(DAO_Experience exp) {
        EXP = exp;
    }
    public List<Experience> getExperiences(){return EXP.findAll();}
    public List<Experience> getExperiencesByPersonne(int id){
        return EXP.findExperiencesByPersonne(id);}
    public void SaveExp(ExpRequest request, Personne personne){
        Experience exp = new Experience(request.getDate(), request.getDescription(), request.getTechnologies());
        exp.setPersonne(personne);
        EXP.save(exp);
    }
}
