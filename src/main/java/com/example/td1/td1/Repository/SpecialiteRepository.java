package com.example.td1.td1.Repository;

import java.util.List;

import com.example.td1.td1.Model.Specialite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SpecialiteRepository extends JpaRepository <Specialite, Long> {

    //@Query("select e.niveau from Etudiant e group by e.specialite")
    //List<Long> findNivSpec();

    
    
}
