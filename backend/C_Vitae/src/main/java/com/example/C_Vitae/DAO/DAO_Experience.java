package com.example.C_Vitae.DAO;

import com.example.C_Vitae.Model.Experience;
import com.example.C_Vitae.Model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DAO_Experience extends JpaRepository<Experience,Integer> {
    @Query("SELECT e FROM Experience e WHERE e.personne.id = ?1")
    List<Experience> findExperiencesByPersonne(Integer id);
}
