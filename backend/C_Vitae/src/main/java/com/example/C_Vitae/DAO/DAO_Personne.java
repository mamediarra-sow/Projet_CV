package com.example.C_Vitae.DAO;

import com.example.C_Vitae.Model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DAO_Personne  extends JpaRepository<Personne,Integer> {

}
