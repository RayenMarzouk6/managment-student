package com.example.projetspringboot.service;


import com.example.projetspringboot.entities.Contrat;
import com.example.projetspringboot.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class ContratService implements IContratService {
    @Autowired
    ContratRepository contratRepository;

    public List<Contrat> findAll()
    {
        return contratRepository.findAll();
    }

    public Contrat findByIdContrat(Long id)
    {
        Contrat contrat = contratRepository.findByIdContrat(id);
        return contrat;
    }

    public Contrat addContrat(Contrat c) {

        Contrat co = contratRepository.save(c);
        return c;
    }
    public void DeleteContrat(Long id) {

        contratRepository.deleteById(id);

    }

    public Contrat updateContrat(Long id , Contrat e) {

        Contrat eq = contratRepository.findByIdContrat(id);
        eq.setIdContrat(id);
        eq.setArchive(e.getArchive());
        eq.setMontantContrat(e.getMontantContrat());
        eq.setDateFinContrat(e.getDateFinContrat());
        eq.setDateDebutContrat(e.getDateDebutContrat());
        eq.setEtudiant(e.getEtudiant());
        eq.setSpecialite(e.getSpecialite());
        contratRepository.save(eq);
        return eq;

    }
    public void retrieveAndUpdateStatusContrat()
    {

        List<Contrat>  list = contratRepository.findAll();
        Date dt =new Date();
        //ajouter 15 jours au date d'aujourd'hui
        Calendar ca = Calendar.getInstance();
        ca.setTime(dt);
        ca.add(Calendar.DATE, 15);
        dt = ca.getTime();

        for (Contrat c :list) {
            if (c.getDateFinContrat().compareTo(dt)>0){
                System.out.println("ID Contrat :"+c.getIdContrat()+"Date Fin Contrat :"+c.getDateFinContrat()+"Specialte :"+c.getSpecialite()+"Etudiant Concernes :"+c.getEtudiant());
                c.setArchive(Boolean.TRUE);
                contratRepository.save(c);
            }
        }
    }
}
