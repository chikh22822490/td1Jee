package com.example.td1.td1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

import com.example.td1.td1.Model.Departement;

@RepositoryRestResource
public interface DepartementRepository extends JpaRepository <Departement, Long>{

    @Query("select d from Departement d where d.idDepartement in (select e.iddepartement from Etudiant e where e.dateEntree=(select max(e.dateEntree) from Etudiant e))")
    List<Departement> findByEtudiantAnciList();

    /*@Query(value = "select d from Departement d where d.idDepartement in (select e.iddepartement from Etudiant e group by e.iddepartement where count(e.iddepartement)=min(select count(e.iddepartement) from Etudiant e group by e.iddepartement))")
    List<Departement> findDeptMinEtud();

    /*@Query("select d from Departement d where count(d.etudiants) = (select max(count(e)) from Etudiants e group by e.Departement)")
    List<Departement> findDepMaxEtud();

    /*@Query("select d from Departement d where count(d.etudiants)=0")
    List<Departement> findDeptNoEtud();

    /*@Query("select d from Departement d where d.etudiant.moyenne = (select max(e.moyenne) from Etudiants e)")
    List<Departement> findDepBestEtud();

    /*@Query("select d from Departement d where avg(d.etudiants.moyenne)>10 order by d")
    List<Departement> findDepMoyValid();*/
}
