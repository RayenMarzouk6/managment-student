package com.example.projetspringboot.controller;

import com.example.projetspringboot.entities.Contrat;
import com.example.projetspringboot.entities.Departement;
import com.example.projetspringboot.entities.Etudiant;
import com.example.projetspringboot.service.DepartementService;
import com.example.projetspringboot.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    DepartementService departementService;

    @GetMapping("/retrieve-all-Etudiant")
    public String getEtudiant(Model model) {

        List<Etudiant> listEtudiant = etudiantService.findAll();
        model.addAttribute("listetudiant",listEtudiant);
        return "etudiant/listetudiant";
    }
    /*
    @GetMapping("/retrieve-all-EtudiantID/{id}")
    @ResponseBody
    public Etudiant getEtudiantsbyid(@PathVariable Long id){

        Etudiant etudiant = etudiantService.findByIdEtudiant(id);
        return etudiant ;
    }*/
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("etudiant", new Etudiant()); // Universite est votre classe de modèle
        return "etudiant/etudiantform"; // Le nom de votre fichier universiteform.html
    }

    @PostMapping("/addEtudiant")
     public String addEtudiant(@ModelAttribute Etudiant etudiant, RedirectAttributes redirectAttributes) {
        etudiantService.addEtudiant(etudiant);
        redirectAttributes.addFlashAttribute("successMessage", "etudiant ajoutée avec succès!");
        return "redirect:/etudiant/retrieve-all-Etudiant";

    }

    @DeleteMapping("/delete")
      public String deleteEtudiant(@RequestParam("etudiantId") Long id) {
        etudiantService.DeleteEtudiant(id);
        return "redirect:/etudiant/retrieve-all-Etudiant";

    }

    @GetMapping("/update")
    public String updatetudiant(@RequestParam("etudiantId") Long id, Model model) {

        Etudiant etudiant = etudiantService.findByIdEtudiant(id);

        model.addAttribute("etudiant", etudiant);
        // send over to our form
        return "departement/updatetudiant";
    }
    @PostMapping("/updateEtudiant")
    public String updateEtudiant(@ModelAttribute Etudiant etd) {
        Etudiant etudiant =etudiantService.updateEtudiant(etd.getIdEtudiant(),etd);
        return "redirect:/etudiant/retrieve-all-Etudiant";
    }
    /*
    @PutMapping("/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idEquipe}")
    @ResponseBody
    Etudiant AssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable Integer idContrat,@PathVariable Integer idEquipe)
    {
       Etudiant x = etudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
       return x;
    }
    @PutMapping("/affectContratToEtudiant/{idContrat}/{nom}/{prenom}")
    @ResponseBody
    Contrat affectContratToEtudiant(@PathVariable Integer idContrat , @PathVariable String nom , @PathVariable  String prenom) {
        Contrat c = etudiantService.affectContratToEtudiant(idContrat,nom,prenom);
        return c;
    }
    @GetMapping("/getEtudiantsByDepartement/{idDepart}")
    @ResponseBody
    Set<Etudiant> getEtudiantsByDepartement(@PathVariable  Integer idDepart) {
        Set<Etudiant> listE = etudiantService.getEtudiantsByDepartement(idDepart);
        return listE;
    }*/
}
