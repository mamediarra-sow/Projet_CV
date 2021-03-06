package com.example.C_Vitae.Service;

import com.example.C_Vitae.DAO.DAO_Certification;
import com.example.C_Vitae.Formulaire.CertRequest;
import com.example.C_Vitae.Model.Certification;
import com.example.C_Vitae.Model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertService {
    private final DAO_Certification CERT;
    @Autowired
    public CertService(DAO_Certification cert) {
        CERT = cert;
    }

    public List<Certification> getCertifications(){return CERT.findAll();}
    public List<Certification> getCertificationsByPersonne(int id){
        return CERT.findCertificationsByPersonne(id);}
    public void SaveCert(CertRequest certRequest, Personne personne){
        Certification cert = new Certification(certRequest.getDate(), certRequest.getLien_certificat());
        cert.setPersonne(personne);
        CERT.save(cert);
    }
}
