package com.example.td1.td1.Controller;

import java.util.List;

import com.example.td1.td1.Model.Departement;
import com.example.td1.td1.Model.Etudiant;
import com.example.td1.td1.Model.Specialite;
import com.example.td1.td1.Repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/etudiant")
public class EtudiantController {

    @Autowired
	EtudiantRepository et;

    @GetMapping("/GetE")
    public List<Etudiant> afficherE()
    {
        return et.findAll();
    }

    @PostMapping("/AddE")
    public Etudiant AjouterEtudiants(@RequestBody Etudiant e)
    {
        return et.save(e);
    }

    @GetMapping("/q1")
    public List<Etudiant> afficherEInfo()
    {
        return et.findEtudiantInfo();
    }
    
}
