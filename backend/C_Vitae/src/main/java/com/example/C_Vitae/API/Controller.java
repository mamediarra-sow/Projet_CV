package com.example.C_Vitae.API;

import com.example.C_Vitae.Model.Personne;
import com.example.C_Vitae.Service.ServicesAllClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
private  final ServicesAllClass Service;
    @Autowired
    public Controller(ServicesAllClass service) {
        Service = service;
    }
    public List<Personne> getPersonnes(){
        return Service.getPersonnes();
    }
}
