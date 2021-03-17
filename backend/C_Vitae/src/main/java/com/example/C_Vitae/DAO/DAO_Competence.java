package com.example.C_Vitae.DAO;

import com.example.C_Vitae.Model.Competence;
import com.example.C_Vitae.Model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DAO_Competence extends JpaRepository<Competence,Integer> {
    @Query("SELECT c FROM Competence c WHERE c.personne.id=?1")
    List<Competence> findCompetencesByPersonne(Integer id);
}
