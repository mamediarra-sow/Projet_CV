package com.example.C_Vitae.API;

import com.example.C_Vitae.Model.*;
import com.example.C_Vitae.Registration.RegistrationRequest;
import com.example.C_Vitae.Registration.RegistrationService;
import com.example.C_Vitae.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class Controller {
private  final FormService Service;
private final CertService CertService;
private final PerService  perService;
private final ExpService expService;
private final CompService compService;
private final RegistrationService registrationService;
    @Autowired
    public Controller(RegistrationService registrationservice,PerService perservice,FormService service,CertService serv,ExpService expservice,CompService compservice) {
        Service = service;
        CertService=serv;
        expService = expservice;
        compService = compservice;
        perService = perservice;
        registrationService = registrationservice;
    }
    @GetMapping(path = "/listePersonne")
    public List<Personne> getPersonnes(){
        return perService.getPersonnes();
    }
    @PostMapping(path = "/addPersonne")
    public void addNewPersonne(@RequestBody Personne personne){
        perService.addNewPersonne(personne);
    }
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
    @DeleteMapping(path = "/delPersonne/{id}")
    public void deletePersonne(@PathVariable("id") Integer id){
        perService.deletePersonne(id);
    }
    @PutMapping(path="/upPersonne/{id}")
    public void updatePersonne(@PathVariable("id") Integer id,@RequestParam(required = false) String adresse,@RequestParam(required = false)  String email){
        perService.updatePersonne(id,adresse,email);
    }
    @PostMapping(path = "/register")
    public String registration(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
    @GetMapping(path = "/confirm")
    public String confirmEmail(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }
}
