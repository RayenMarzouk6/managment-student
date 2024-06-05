package com.example.projetspringboot.service;



import com.example.projetspringboot.entities.Departement;
import com.example.projetspringboot.entities.Universite;

import java.util.List;
import java.util.Set;

public interface IDepartementService {
    public List<Departement> findAll();

    public Departement findByIdDepartement(Long id);

    public Departement addDepartement(Departement d);
    public void DeleteDepartement(Long id);
    public Departement updateDepartement(Long id , Departement e);
    public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId);
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
    public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
    public Universite getUniversiteByDepartementId(Long departementId);
}
