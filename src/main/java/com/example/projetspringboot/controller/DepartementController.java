package com.example.projetspringboot.controller;



import com.example.projetspringboot.DAO.departdetails;
import com.example.projetspringboot.entities.Departement;
import com.example.projetspringboot.entities.Universite;
import com.example.projetspringboot.service.DepartementService;
import com.example.projetspringboot.service.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/departement")
public class DepartementController {
    @Autowired
    DepartementService departementService;
    @Autowired
    UniversiteService universiteService;

    @GetMapping("/retrieve-all-Departement")
    public String getdepartement(Model model) {
        List<Departement> listDepartements = departementService.findAll();
        List<departdetails> departementDetailsList = new ArrayList<>();

        for (Departement departement : listDepartements) {
            // Récupérer l'université associée à ce département
            Universite univ = departementService.getUniversiteByDepartementId(departement.getIdDepart());

            // Créer un objet DepartementDetails pour stocker les détails du département et de son université
            departdetails departementDetails = new departdetails(departement, univ);

            // Ajouter DepartementDetails à la liste
            departementDetailsList.add(departementDetails);
        }

        // Ajouter la liste des détails du département à l'objet Model
        model.addAttribute("departementDetailsList", departementDetailsList);
        return "departement/listdepartement";
    }

   @GetMapping("/univdepart")
    public String getunivdepart(@RequestParam("departementId") Long id,Model model) {
       Universite univ = departementService.getUniversiteByDepartementId(id);
       model.addAttribute("univ", univ);

       return "departement/details";
   }

     @PostMapping("/addDepartement")
    public String addDepartement(@ModelAttribute Departement depart, RedirectAttributes redirectAttributes) {
        departementService.addDepartement(depart);
        redirectAttributes.addFlashAttribute("successMessage", "Université ajoutée avec succès!");
        return "redirect:/departement/retrieve-all-Departement"; // Redirection vers la page qui affiche toutes les universités
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("departement", new Departement()); // Universite est votre classe de modèle
        return "departement/departementform"; // Le nom de votre fichier universiteform.html
    }
    @GetMapping("/delete")
    public String deletedept(@RequestParam("departementId") Long id) {

        departementService.DeleteDepartement(id);
        return "redirect:/departement/retrieve-all-Departement";
    }
    @GetMapping("/update")
    public String updatedept(@RequestParam("departementId") Long id, Model model) {

        Departement departement = departementService.findByIdDepartement(id);

        model.addAttribute("departement", departement);

        // send over to our form
        return "departement/updatedepartement";
    }
    @PostMapping("/updateDepartement")
    public String updateDepartement(@ModelAttribute Departement d) {
        Departement departement =departementService.updateDepartement(d.getIdDepart(),d);
        return "redirect:/departement/retrieve-all-Departement";
    }


/*
@GetMapping("/departementsByUniversite/{idUniversite}")
    public String getDepartementsByUniversite(@PathVariable Integer idUniversite, Model model) {
        Set<Departement> departements = departementService.retrieveDepartementsByUniversite(idUniversite);
        model.addAttribute("departements", departements);
        return "departementsByUniversite"; // Nom de votre vue Thymeleaf
    }
  @GetMapping("/retrieve-all-DepartementsID/{id}")
    @ResponseBody
    public Departement getDepartementsbyid(@PathVariable Long id){

        Departement departement = departementService.findByIdDepartement(id);
        return departement ;
    }
    @GetMapping("/assignunivdepart")
    public String assdepuniv( Model model) {

        // get the employee from the service
        List<Universite> luniversite = universiteService.findAll();
        List<Departement> ldepartement = departementService.findAll();
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("luniversite", luniversite);
        model.addAttribute("ldepartement", ldepartement);
        // send over to our form
        return "departement/assigdepartuniv";
    }
    @PostMapping("/assignDepartementToUniversite")
    public String assignDepartementToUniversite(@RequestParam("idUniversite") Integer idUniversite,
                                                @RequestParam("idDepartement") Integer idDepartement) {
        departementService.assignUniversiteToDepartement(idUniversite, idDepartement);
        return "redirect:/departement/retrieve-all-Departement";
    }


    @PutMapping("/addUnivinDepartement/{idUniversite}/{idDepartement}")
    @ResponseBody
    public void assignUniversiteToDepartement(@PathVariable Integer idUniversite, @PathVariable  Integer idDepartement){
        departementService.assignUniversiteToDepartement(idUniversite,idDepartement);

    }

    @GetMapping("/retrieveDepartementsByUniversite/{idUniversite}")
    public Set<Departement> retrieveDepartementsByUniversite( @PathVariable Integer idUniversite)
    {
        return departementService.retrieveDepartementsByUniversite(idUniversite);
    }
    */
}
