package com.example.td1.td1.Repository;

import java.util.List;

import com.example.td1.td1.Model.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository <Etudiant, Long>{
	
    //@RestResource(path ="/Q1")
    @Query("select e from Etudiant e where e.iddepartement.nomDepartement='Informatique' order by e.dateEntree DESC")
    List<Etudiant> findEtudiantInfo();

    @Query(value = "select e from Etudiant e where e.nomE LIKE ?1")//or %?2 or %?3 or %?4  or %?6 or %?7 or %?8
    List<Etudiant> findByNameL(String L);//String L2, String L3, String L4, String M1 , String M2, String M3, String M4

    @Query(value = "select e from Etudiant e where e.nomE LIKE ?1")//or %?2 or %?3 or %?4  or %?6 or %?7 or %?8
    List<Etudiant> findByNameM(String M);

    @Query("select avg(e.moyenne) from Etudiant e")
    Double moyDeMoy();

    @Query("select e from Etudiant e where e.moyenne in (select max(e.moyenne) from Etudiant e group By e.iddepartement)")
    List<Etudiant> findMaxMoyDept();

    @Query("select e from Etudiant e where e.moyenne = (select max(e.moyenne) from Etudiant e)")
    List<Etudiant> findEtudMaxMoy();

    @Query("select count(e.iddepartement.idDepartement) from Etudiant e group by e.iddepartement.idDepartement")
    List<Long> findEtudNumberDept();

    @Query(value = "select e.niveau from etudiant e group by e.niveau having count(e.niveau) in (select max(cniveau) from (select count(e.niveau) as cniveau from etudiant e group by e.niveau)c)",nativeQuery = true)
    Long findNivMaxEtud();

}
