package com.example.projetspringboot.controller;


import com.example.projetspringboot.service.DepartementService;
import com.example.projetspringboot.service.EntrepriseService;
import com.example.projetspringboot.service.EquipeService;
import com.example.projetspringboot.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class IndexController {


	@Autowired
	private DepartementService deptService ;

	@Autowired
	private EtudiantService etdservices;
	@Autowired
	private EquipeService equipeService;
	@Autowired
	private EntrepriseService entrepriseService;

	@GetMapping(value = "/")
	 public String index()
	 {
		return "index2";
	 }


	@RequestMapping(value = "/universite", method = RequestMethod.GET)
	public String viewUniversitePage(Model model)
	{
		return "redirect:/universite/user/retrieve-all-Universite";

	}
	@RequestMapping(value = "/etudiant", method = RequestMethod.GET)
	public String viewStudentPage(Model model)
	{
		return "redirect:/etudiant/retrieve-all-Universite";

	}
	@RequestMapping(value = "/contrat", method = RequestMethod.GET)
	public String viewdcontratPage(Model model)
	{
		return "redirect:/contrat/retrieve-all-Universite";
	}

	@RequestMapping(value = "/entreprise", method = RequestMethod.GET)
	public String viewentreprisePAge(Model model)
	{

		return "redirect:/entreprise/retrieve-all-Universite";
	}
	@RequestMapping(value = "/equipe", method = RequestMethod.GET)
	public String viewequipePage(Model model)
	{

		return "redirect:/equipe/retrieve-all-Universite";
	}
	@RequestMapping(value = "/departement", method = RequestMethod.GET)
	public String viewdepartementPage(Model model)
	{

		return "redirect:/departement/retrieve-all-Departement";
	}

	
	
	
	
}
