package com.example.projetspringboot.controller;

import com.example.projetspringboot.entities.Universite;
import com.example.projetspringboot.service.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/universite")
public class UniversiteController {
    @Autowired
    UniversiteService universiteService;

    @GetMapping("/user/retrieve-all-Universite")
    public String getUniversite(Model model) {

        List<Universite> listUniversite = universiteService.findAll();
        model.addAttribute("listUniversite", listUniversite);

        return "universite/listuniversite";

    }

    @GetMapping("/user/add")
    public String showAddForm(Model model) {
        model.addAttribute("universite", new Universite()); // Universite est votre classe de modèle
        return "universite/universiteform"; // Le nom de votre fichier universiteform.html
    }
    @PostMapping("/user/addUniversite")

    public String addUniversite(@ModelAttribute Universite universite, RedirectAttributes redirectAttributes) {
        universiteService.addUniversite(universite);
        redirectAttributes.addFlashAttribute("successMessage", "Université ajoutée avec succès!");
        return "redirect:/universite/user/retrieve-all-Universite"; // Redirection vers la page qui affiche toutes les universités
    }
    @GetMapping("/admin/delete")
    @PreAuthorize("hasRole('ROLE-Admin')")
    public String delete(@RequestParam("universiteId") Long id) {

        universiteService.DeleteUniversite(id);
        return "redirect:/universite/user/retrieve-all-Universite";
    }
    @GetMapping("/update")
    public String updateUniv(@RequestParam("universiteId") Long id, Model model) {

        // get the employee from the service
       Universite universite = universiteService.findByIdUniversite(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("universite", universite);

        // send over to our form
        return "universite/user/updateuniversite";
    }
    @PostMapping("/updateUniversite")

    public String updateUniversite(@ModelAttribute Universite c) {
        Universite universite =universiteService.updateUniversite(c.getIdUniv(),c);
        return "redirect:/universite/retrieve-all-Universite";
    }
     /*
    @GetMapping("/retrieve-all-UniversiteID/{id}")

    public Universite getUniversitebyid(@PathVariable Long id){

        Universite universite = universiteService.findByIdUniversite(id);
        return universite ;
    }*/
}
