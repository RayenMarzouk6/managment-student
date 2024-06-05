package com.example.projetspringboot.service;

import com.example.projetspringboot.entities.Universite;
import com.example.projetspringboot.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteService implements IUniversiteService{
    @Autowired
    UniversiteRepository universiteRepository;

    public List<Universite> findAll()
    {
        return universiteRepository.findAll();
    }

    public Universite findByIdUniversite(Long id)
    {
        Universite universite = universiteRepository.findByIdUniv(id);
        return universite;
    }

    public Universite addUniversite(Universite c) {

        Universite co = universiteRepository.save(c);
        return c;
    }
    public void DeleteUniversite(Long id) {

        universiteRepository.deleteById(id);

    }

    public Universite updateUniversite(Long id , Universite e) {

        Universite eq = universiteRepository.findByIdUniv(id);
        eq.setIdUniv(id);
        eq.setNomUniv(e.getNomUniv());
        eq.setDepartements(e.getDepartements());
        universiteRepository.save(eq);
        return eq;

    }
}
