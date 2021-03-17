package com.example.C_Vitae.DAO;

import com.example.C_Vitae.Model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DAO_Formation extends JpaRepository<Formation,Integer> {
    @Query("SELECT f FROM Formation f WHERE f.personne.id = ?1")
    List<Formation> findFormationsByPersonne(Integer id);
}
