package com.example.td1.td1.Controller;

import java.util.List;

import com.example.td1.td1.Model.Specialite;
import com.example.td1.td1.Repository.SpecialiteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/specialite")
public class SpecialiteCOntroller {

    @Autowired
    SpecialiteRepository sp;

    @GetMapping("/GetAllD")
    public List<Specialite> afficherS()
    {
        return sp.findAll();
    }

    @PostMapping("/AddD")
    public Specialite ajouterSpecialite(@RequestBody Specialite s)
    {
        return sp.save(s);
    }

    @GetMapping("/Q1")
    public List<Long> afficherEtudiantAnciList()
    {
        return sp.findNivSpec();
    }
    
}
