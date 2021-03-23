package com.example.C_Vitae.API;

import com.example.C_Vitae.Formulaire.CertRequest;
import com.example.C_Vitae.Formulaire.CompRequest;
import com.example.C_Vitae.Formulaire.ExpRequest;
import com.example.C_Vitae.Formulaire.FormRequest;
import com.example.C_Vitae.Model.*;
import com.example.C_Vitae.Registration.RegistrationRequest;
import com.example.C_Vitae.Registration.RegistrationService;
import com.example.C_Vitae.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    ////////////////Requete personne ////////////////
    @GetMapping(path = "/listePersonne")
    public List<Personne> getPersonnes(){
        return perService.getPersonnes();
    }
    @DeleteMapping(path = "/delPersonne/{id}")
    public void deletePersonne(@PathVariable("id") Integer id){
        perService.deletePersonne(id);
    }
    @PutMapping(path="/upPersonne/{id}")
    public void updatePersonne(@PathVariable("id") Integer id,@RequestParam(required = false) String adresse,@RequestParam(required = false)  String email){
        perService.updatePersonne(id,adresse,email);
    }
    //////////////////////Requete Formation/////////////////////
    @GetMapping(path = "/personneForm")
    public List<Formation> getFormationsByPersonne(){
        Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
      Personne personneLogged = perService.findByUsername(authentication.getName());
        return Service.getFormationsByPersonne(personneLogged.getId());
    }
    @PostMapping(path = "/addFormation")
    public void saveFormation(@RequestBody FormRequest request){
        Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
        Personne personneLogged = perService.findByUsername(authentication.getName());
        Service.saveForm(request,personneLogged);

    }
    //////////////// Requete Certification/////////////////////
    @PostMapping(path = "/addCertification")
    public void saveCertification(@RequestBody CertRequest request){
        Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
        Personne personneLogged = perService.findByUsername(authentication.getName());
        CertService.SaveCert(request,personneLogged);

    }
    @GetMapping(path = "/personneCert")
    public List<Certification> getCertificationsByPersonne(){
        Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
        Personne personneLogged = perService.findByUsername(authentication.getName());
        return CertService.getCertificationsByPersonne(personneLogged.getId());
    }
    //////////////////////Requete Experience/////////////////////////////
    @PostMapping(path = "/addExperience")
    public void saveExperience(@RequestBody ExpRequest request){
        Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
        Personne personneLogged = perService.findByUsername(authentication.getName());
        expService.SaveExp(request,personneLogged);

    }
    @GetMapping(path="/personneExp")
    public List<Experience> getExperiencesByPersonne(){
        Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
        Personne personneLogged = perService.findByUsername(authentication.getName());
        return expService.getExperiencesByPersonne(personneLogged.getId());
    }

    ////////////////////////Requete Compétence ////////////////////////////
    @PostMapping(path = "/addCompetence")
    public void saveCompetence(@RequestBody CompRequest request){
        Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
        Personne personneLogged = perService.findByUsername(authentication.getName());
        compService.SaveComp(request,personneLogged);

    }
    @GetMapping(path="/personneComp")
    public List<Competence> getCompetencesByPersonne(){
        Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
        Personne personneLogged = perService.findByUsername(authentication.getName());
        return compService.getCompetencesByPersonne(personneLogged.getId());
    }
    //////////////////Inscription///////////////////////////////////////

    @PostMapping(path = "/accueil/register")
    public String registration(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }
    @GetMapping(path = "/accueil/confirm")
    public String confirmEmail(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }
}
