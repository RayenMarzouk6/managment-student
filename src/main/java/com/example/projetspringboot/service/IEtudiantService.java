package com.example.projetspringboot.service;



import com.example.projetspringboot.entities.Contrat;
import com.example.projetspringboot.entities.Etudiant;

import java.util.List;
import java.util.Set;

public interface IEtudiantService {
    public List<Etudiant> findAll();

    public Etudiant findByIdEtudiant(Long id);

    public Etudiant addEtudiant(Etudiant c);
    public void DeleteEtudiant(Long id);

    public Etudiant updateEtudiant(Long id , Etudiant e);

    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
    public Contrat affectContratToEtudiant (Integer idContrat, String nomE, String prenomE);

    public Set<Etudiant> getEtudiantsByDepartement(Integer idDepartement);
}
