package com.example.C_Vitae.DAO;

import com.example.C_Vitae.Model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DAO_Personne  extends JpaRepository<Personne,Integer> {
    @Query("SELECT p FROM Personne p WHERE p.email=?1")
    Optional<Personne> findPersonneByEmail(String email);

}
