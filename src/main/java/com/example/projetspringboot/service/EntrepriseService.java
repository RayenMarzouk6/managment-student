package com.example.projetspringboot.service;



import com.example.projetspringboot.entities.Entreprise;
import com.example.projetspringboot.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepriseService implements  IEntrepriseService {
    @Autowired
    EntrepriseRepository entrepriseRepository;
    public List<Entreprise> findAll()
    {
        return entrepriseRepository.findAll();
    }

    public Entreprise findByIdEntreprise(Long id)
    {
        Entreprise entreprise = entrepriseRepository.findByIdEntreprise(id);
        return entreprise;
    }

    public Entreprise addEntreprise(Entreprise c) {

        Entreprise co = entrepriseRepository.save(c);
        return c;
    }
    public void DeleteEntreprise(Long id) {

        entrepriseRepository.deleteById(id);

    }

    public Entreprise updateEntreprise(Long id , Entreprise e) {

        Entreprise eq = entrepriseRepository.findByIdEntreprise(id);
        eq.setIdEntreprise(id);
        eq.setNomEntreprise(e.getNomEntreprise());
        eq.setEquipes(e.getEquipes());
        entrepriseRepository.save(eq);
        return eq;

    }
}
