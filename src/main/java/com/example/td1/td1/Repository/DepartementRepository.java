package com.example.td1.td1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

import com.example.td1.td1.Model.Departement;

@RepositoryRestResource
public interface DepartementRepository extends JpaRepository <Departement, Long>{

    /*@Query("select d from Departement d where d in (select e from Etudiant e where e.dateEntree=max(e.dateEntree))")
    List<Departement> findByEtudiantAnciList();

    @Query("select d from Departement d where count(d.Etudiant)=(select min(count(e)) from Etudiants e Group By e.Departement")
    List<Departement> findDeptMinEtud();

    @Query("select d from Departement d where count(d.Etudiant) = (select max(count(e)) from Etudiants e group by e.Departement)")
    List<Departement> findDepMaxEtud();

    @Query("select d from Departement d where count(d.Etudiant)=0")
    List<Departement> findDeptNoEtud();

    @Query("select d from Departement d where d.etudiant.moyenne = (select max(e.moyenne) from Etudiants e)")
    List<Departement> findDepBestEtud();

    @Query("select d from Departement d where avg(d.etudiant.moyenn)>10 order by d")
    List<Departement> findDepMoyValid();*/
}
