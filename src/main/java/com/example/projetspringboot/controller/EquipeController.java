package com.example.projetspringboot.controller;

import com.example.projetspringboot.entities.Departement;
import com.example.projetspringboot.entities.Equipe;
import com.example.projetspringboot.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/equipe")
public class EquipeController {
    public Long id;
    @Autowired
    private EquipeService equipeService ;
    @GetMapping("/retrieve-all-equipes")
    public String getEquipes(Model model) {

        List<Equipe> listEquipes = equipeService.findAllBy();
        model.addAttribute("listEquipes", listEquipes);
        return "equipe/listequipe";

    }
    /*@GetMapping("/retrieve-all-equipes-byID/{id}")
    @ResponseBody
    public Equipe getEquipesbyid(@PathVariable Long id){

       Equipe Equipe = equipeService.findByIdEquipe(id);
        return Equipe ;

    }*/

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("equipe", new Equipe());
        return "equipe/equipeform"; // Le nom de votre fichier equipeform.html
    }

    @PostMapping("/addEquipe")
    public String addEquipe(@ModelAttribute Equipe e, RedirectAttributes redirectAttributes) {
        equipeService.addEquipe(e);
        return "redirect:/equipe/retrieve-all-equipes";
    }

    @GetMapping("/delete")
    public String deleteEquipe(@RequestParam("equipeId") Long id) {
        equipeService.DeleteEquipe(id);
        return "redirect:/equipe/retrieve-all-equipes";
    }

    @GetMapping("/update")
    public String updatequipe(@RequestParam("equipeId") Long id, Model model) {

        Equipe equipe = equipeService.findByIdEquipe(id);

        model.addAttribute("equipe",equipe);

        // send over to our form
        return "equipe/updatequipe";
    }
    @PostMapping("/updatequipe")
    public String updateEquipe(@ModelAttribute Equipe e) {
        Equipe equipe =equipeService.updateEquipe(e.getIdEquipe(),e);
        return "redirect:/departement/retrieve-all-Departement";
    }

}
