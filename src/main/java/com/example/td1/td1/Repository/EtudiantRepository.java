package com.example.td1.td1.Repository;

import java.util.List;

import com.example.td1.td1.Model.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository <Etudiant, Long>{
	
    @RestResource(path ="/Q1")
    @Query("select e from Etudiant e where e.iddepartement.nomDepartement='Informatique' order by e.dateEntree DESC")
    List<Etudiant> findEtudiantInfo();

    @RestResource(path ="/Q2")
    List<Etudiant> findByNomEContainingAndNomEContaining(String x, String y);

    @Query("select avg(e.moyenne) from Etudiant e")
    Double moyDeMoy();

    @Query("select e from Etudiant e where e.moyenne in (select max(e.moyenne) from Etudiant e group By e.iddepartement)")
    List<Etudiant> findMaxMoyDept();

    @Query("select e from Etudiant e where e.moyenne = (select max(e.moyenne) from Etudiant e)")
    List<Etudiant> findEtudMaxMoy();

    @Query("select count(e.iddepartement) from Etudiant e group by e.iddepartement")
    List<Long> findEtudNumberDept();

    @Query(value = "select e.niveau from etudiant e group by e.niveau having count(e.niveau) in (select max(cniveau) from (select count(e.niveau) as cniveau from etudiant e group by e.niveau)c)",nativeQuery = true)
    Long findNivMaxEtud();

}
