package com.example.projetspringboot.controller;



import com.example.projetspringboot.entities.Contrat;
import com.example.projetspringboot.entities.Etudiant;
import com.example.projetspringboot.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    ContratService contratService;
    @GetMapping("/retrieve-all-contrats")
    public String getContrats(Model model) {

        List<Contrat> listcontrats = contratService.findAll();
        model.addAttribute("listcontrats",listcontrats);
        return "contrat/listcontrat";
    }
    /*
    @GetMapping("/retrieve-all-contratsID/{id}")
    @ResponseBody
    public Contrat getContratsbyid(@PathVariable Long id){

        Contrat contrat = contratService.findByIdContrat(id);
        return contrat ;
    }*/
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("contrat", new Contrat()); // Universite est votre classe de modèle
        return "contrat/contratform"; // Le nom de votre fichier universiteform.html
    }
    @PostMapping("/addContrat")
    public String addContrat(@ModelAttribute Contrat contrat, RedirectAttributes redirectAttributes) {
        contratService.addContrat(contrat);
        redirectAttributes.addFlashAttribute("successMessage", "contrat ajoutée avec succès!");
        return "redirect:/contrat/retrieve-all-contrats";
    }

    @DeleteMapping("/delete")
    public String deleteContrat(@RequestParam("contratId") Long id) {
        contratService.DeleteContrat(id);
        return "redirect:/contrat/retrieve-all-contrats";

    }

    @GetMapping("/update")
    public String updatcontrat(@RequestParam("contratId") Long id, Model model) {

        Contrat contrat = contratService.findByIdContrat(id);

        model.addAttribute("contrat", contrat);
        // send over to our form
        return "contrat/updatecontrat";
    }

}
