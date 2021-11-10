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

    //@Query(value = "select d from Departement d where d.idDepartement in (select e.iddepartement from Etudiant e group by e.iddepartement where count(e.iddepartement)=min(select count(e.iddepartement) from Etudiant e group by e.iddepartement))")
    //List<Departement> findDeptMinEtud();

    //@Query("select d from Departement d where count(d.etudiants) = (select max(count(e)) from Etudiants e group by e.Departement)")
    //List<Departement> findDepMaxEtud();

    @Query("select d from Departement d group by d.idDepartement having d.idDepartement = ( select e.iddepartement from Etudiant e group by e.iddepartement having count(e.iddepartement)=0)")
    List<Departement> findDeptNoEtud();

    @Query("select d from Departement d group by d.idDepartement having d.idDepartement in (select e.iddepartement from Etudiant e group by e.iddepartement,e.moyenne having e.moyenne=(select max(e.moyenne) from Etudiant e))")
    List<Departement> findDepBestEtud();

    //select d from departement d group by d.id_departement having d.id_departement in (select e.id_dept from Etudiant e group by e.id_dept having avg(e.moyenne)=(select max(cdept) from ( select avg(e.moyenne) as cdept from Etudiant e group by e.id_dept)c));
    //@Query(value = "select d from Departement d join fetch d.etudiants e where e.moyenne = 9.35")
    @Query(value = "select d from Departement d group by d.id_departement having d.id_departement in (select e.id_dept from Etudiant e group by e.id_dept having avg(e.moyenne)=(select max(cdept) from ( select avg(e.moyenne) as cdept from Etudiant e group by e.id_dept)c));",nativeQuery = true)
    List<Departement> findDepBestAvg();
    
    @Query("select d from Departement d group by d.idDepartement having d.idDepartement Not In (select e.iddepartement.idDepartement from Etudiant e group by e.iddepartement.idDepartement, e.moyenne having e.moyenne < 10)")//avg(d.etudiants.moyenne)>10 order by d
    List<Departement> findDepMoyValid();
}
