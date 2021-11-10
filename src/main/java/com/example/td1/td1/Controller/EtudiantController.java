package com.example.td1.td1.Controller;

import java.util.List;

import com.example.td1.td1.Model.Etudiant;
import com.example.td1.td1.Repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/etudiant")
public class EtudiantController {

    @Autowired
	EtudiantRepository et;

    @GetMapping("/GetAllE")
    public List<Etudiant> afficherE()
    {
        return et.findAll();
    }

    @PostMapping("/AddE")
    public Etudiant AjouterEtudiants(@RequestBody Etudiant e)
    {
        return et.save(e);
    }

    @GetMapping("/Q1")
    public List<Etudiant> afficherEtudInfo()
    {
        return et.findEtudiantInfo();
    }

    @GetMapping("/Q2")
    public List<Etudiant> afficherByNameL()
    {
        return et.findByNameL("%L%");//"_L%", "%L","%L_",*//*,"_M%","%M","%M_","%M%"
    }
    
    @GetMapping("/Q3")
    public List<Etudiant> afficherByNameM()
    {
        return et.findByNameM("%M%");//"_L%", "%L","%L_",*//*,"_M%","%M","%M_","%M%"
    }

    @GetMapping("/Q4")
    public Double affichermoyDeMoy()
    {
        return et.moyDeMoy();
    }

    @GetMapping("/Q5")
    public List<Etudiant> afficherMaxMoyDept()
    {
        return et.findMaxMoyDept();
    }

    @GetMapping("/Q6")
    public List<Etudiant> afficherEtudMaxMoy()
    {
        return et.findEtudMaxMoy();
    }

    @GetMapping("/Q7")
    public List<Long> afficherEtudNumberDept()
    {
        return et.findEtudNumberDept();
    }

    @GetMapping("/Q8")
    public Long afficherNivMaxEtud()
    {
        return et.findNivMaxEtud();
    }
    
}
