package com.example.td1.td1.Repository;

import java.util.List;

import com.example.td1.td1.Model.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository <Etudiant, Long>{
	
    //@RestResource(path ="/Q1")
    @Query("select e from Etudiant e where e.iddepartement.nomDepartement='Informatique' order by e.dateEntree DESC")
    List<Etudiant> findEtudiantInfo();

    /*@Query("select e.nome from Etudiant e where e.nome like 'l%' or '-l%' or '%l' or '%l-' and 'm%' or '-m%' or '%m' or '%m-'")
    List<Etudiant> findByNameLM();

    @Query("select avg(e.moyenne) from Etudiant e")
    Double moyDeMoy();

    @Query("select e from Etudiant e where e.moyenne in (select max(e.moyenne) from Etudiants e group By e.Departement)")
    List<Etudiant> findMaxMoyDept();

    @Query("select e from Etudiants e where e.moyenne = (select max(e.moyenne) from Etudians e)")
    List<Etudiant> findEtudMaxMoy();

    @Query("select count(e) from Etudiant e Group By e.Departement")
    List<Etudiant> findEtudNumberDept();

    @Query("select e.niveau from Etudiant e order by e.niveau having count(e)=(select max(count(e.niveau)) from Etudiant e group by e.niveau)")
    List<Long> findNivMaxEtud();*/


}
