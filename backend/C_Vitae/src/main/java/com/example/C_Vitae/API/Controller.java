package com.example.C_Vitae.API;

import com.example.C_Vitae.Model.Certification;
import com.example.C_Vitae.Model.Competence;
import com.example.C_Vitae.Model.Experience;
import com.example.C_Vitae.Model.Formation;
import com.example.C_Vitae.Service.CertService;
import com.example.C_Vitae.Service.CompService;
import com.example.C_Vitae.Service.ExpService;
import com.example.C_Vitae.Service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class Controller {
private  final FormService Service;
private final CertService CertService;
private final ExpService expService;
private final CompService compService;
    @Autowired
    public Controller(FormService service,CertService serv,ExpService expservice,CompService compservice) {
        Service = service;
        CertService=serv;
        expService = expservice;
        compService = compservice;
    }

    /*@GetMapping(path = "/listePersonne")
    public List<Personne> getPersonnes(){
        return Service.getPersonnes();
    }
    @PostMapping(path = "/addPersonne")
    public void addNewPersonne(@RequestBody Personne personne){
        Service.addNewPersonne(personne);
    }*/
    @GetMapping(path = "/personneForm/{id}")
    public List<Formation> getFormationsByPersonne(@PathVariable ("id") Integer id){
        return Service.getFormationsByPersonne(id);
    }
    @GetMapping(path = "/personneCert/{id}")
    public List<Certification> getCertificationsByPersonne(@PathVariable ("id") Integer id){
        return CertService.getCertificationsByPersonne(id);
    }
    @GetMapping(path="/personneExp/{id}")
    public List<Experience> getExperiencesByPersonne(@PathVariable("id") Integer id){
        return expService.getExperiencesByPersonne(id);
    }
    @GetMapping(path="/personneComp/{id}")
    public List<Competence> getCompetencesByPersonne(@PathVariable("id") Integer id){
        return compService.getCompetencesByPersonne(id);
    }

}
