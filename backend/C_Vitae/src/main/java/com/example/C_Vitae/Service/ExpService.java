package com.example.C_Vitae.Service;

import com.example.C_Vitae.DAO.DAO_Experience;
import com.example.C_Vitae.Model.Experience;
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
    public List<Experience> getExperiencesByPersonne(int id){return EXP.findExperiencesByPersonne(id);}
}
