package com.example.projetspringboot.controller;


import com.example.projetspringboot.entities.Entreprise;
import com.example.projetspringboot.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entreprise")
public class EntrepriseController {
    @Autowired
    EntrepriseService entrepriseService;

    @GetMapping("/retrieve-all-entreprise")
    public List<Entreprise> getContrats() {

        List<Entreprise> listEntreprise = entrepriseService.findAll();
        return listEntreprise;
    }
    @GetMapping("/retrieve-all-entrepriseID/{id}")
    @ResponseBody
    public Entreprise getEntreprisebyid(@PathVariable Long id){

        Entreprise entreprise = entrepriseService.findByIdEntreprise(id);
        return entreprise ;
    }

    @PostMapping("/addEntreprise")
    @ResponseBody
    public Entreprise addEntreprise(@RequestBody Entreprise e) {
        entrepriseService.addEntreprise(e);
        return e;
    }

    @DeleteMapping("/deleteEntreprise/{id}")
    @ResponseBody
    public void deleteEntreprise(@PathVariable Long id) {
        entrepriseService.DeleteEntreprise(id);

    }

    @PutMapping("/updateEntreprise/{id}")
    @ResponseBody
    public Entreprise updateEntreprise(@PathVariable Long id ,@RequestBody Entreprise c) {
        Entreprise entreprise =entrepriseService.updateEntreprise(id,c);
        return entreprise;
    }
}
