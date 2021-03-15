package com.example.C_Vitae.Service;

import com.example.C_Vitae.DAO.DAO_Personne;
import com.example.C_Vitae.Model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesAllClass {
    private final DAO_Personne DAO;
    @Autowired
    public ServicesAllClass(DAO_Personne dao) {
        DAO = dao;
    }
    public List<Personne> getPersonnes(){
        return DAO.findAll();
    }
    public Optional<Personne> getPersonneById(int id){
        return DAO.findById(id);
    }
}
