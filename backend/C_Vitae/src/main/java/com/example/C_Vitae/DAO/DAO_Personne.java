package com.example.C_Vitae.DAO;

import com.example.C_Vitae.Model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface DAO_Personne  extends JpaRepository<Personne,Integer> {
    @Query("SELECT p FROM Personne p WHERE p.email=?1")
    Optional<Personne> findPersonneByEmail(String email);

    @Modifying
    @Query("UPDATE Personne p " +
            "SET p.enabled = TRUE " +
            "WHERE p.email= ?1")
    int EnablePersonne(String email);

    Personne findByUsername(String username);

    Personne findByemail(String email);
}

