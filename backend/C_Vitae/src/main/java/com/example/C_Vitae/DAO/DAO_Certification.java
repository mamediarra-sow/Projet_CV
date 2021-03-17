package com.example.C_Vitae.DAO;

import com.example.C_Vitae.Model.Certification;
import com.example.C_Vitae.Model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DAO_Certification extends JpaRepository<Certification, Integer> {
    @Query("SELECT cf FROM Certification cf WHERE cf.personne.id = ?1")
    List<Certification> findCertificationsByPersonne(Integer id);
}
