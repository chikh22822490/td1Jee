package com.example.td1.td1.Controller;

import java.util.List;

import com.example.td1.td1.Model.Departement;
import com.example.td1.td1.Repository.DepartementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/departement")
public class DepartementController {

    @Autowired
    DepartementRepository dt;

    @GetMapping("/GetAllD")
    public List<Departement> afficherD()
    {
        return dt.findAll();
    }

    @PostMapping("/AddD")
    public Departement ajouterDepartement(@RequestBody Departement d)
    {
        return dt.save(d);
    }

    @GetMapping("/Q1")
    public List<Departement> afficherEtudiantAnciList()
    {
        return dt.findByEtudiantAnciList();
    }

    /*@GetMapping("/Q2")
    public List<Departement> afficherDeptMinEtud()
    {
        return dt.findDeptMinEtud();
    }*/

    /*@GetMapping("/Q3")
    public List<Departement> afficherDeptMaxEtud()
    {
        return dt.findDeptMaxEtud();
    }*/

    @GetMapping("/Q4")
    public List<Departement> afficherDeptMaxEtud()
    {
        return dt.findDeptNoEtud();
    }

    @GetMapping("/Q5")
    public List<Departement> afficherDepBestEtud()
    {
        return dt.findDepBestEtud();
    }

    @GetMapping("/Q6")
    public List<Departement> afficherDepBestAvg()
    {
        return dt.findDepBestAvg();
    }

    @GetMapping("/Q7")
    public List<Departement> afficherDepMoyValid()
    {
        return dt.findDepMoyValid();
    }

}
