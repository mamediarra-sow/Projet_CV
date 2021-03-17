package com.example.C_Vitae.Service;

import com.example.C_Vitae.DAO.*;
import com.example.C_Vitae.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormService {
    private final DAO_Formation FORM;
    @Autowired
    public FormService(DAO_Formation form){//,DAO_Experience exp,DAO_Competence comp,DAO_Certification) {
        FORM = form;
    }
    public List<Formation> getFormations(){return FORM.findAll();}
    public List<Formation> getFormationsByPersonne(Integer id){return FORM.findFormationsByPersonne(id); }



}