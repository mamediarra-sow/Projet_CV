package com.example.C_Vitae.Service;

import com.example.C_Vitae.DAO.*;
import com.example.C_Vitae.Formulaire.FormRequest;
import com.example.C_Vitae.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {
    private final DAO_Formation FORM;
    @Autowired
    public FormService(DAO_Formation form){//,DAO_Experience exp,DAO_Competence comp,DAO_Certification) {
        FORM = form;
    }
    public List<Formation> getFormations() {
        return FORM.findAll();
    }
    public List<Formation> getFormationsByPersonne(Integer id){
        return FORM.findFormationsByPersonne(id);
    }
    public void saveForm(FormRequest request,Personne personne){
        Formation form = new Formation(request.getDate(), request.getDescription());
        form.setPersonne(personne);
        FORM.save(form);
        }



}