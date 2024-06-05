package com.example.projetspringboot.service;

import com.example.projetspringboot.entities.Contrat;
import com.example.projetspringboot.entities.Equipe;
import com.example.projetspringboot.entities.Etudiant;
import com.example.projetspringboot.repository.ContratRepository;
import com.example.projetspringboot.repository.DepartementRepository;
import com.example.projetspringboot.repository.EquipeRepository;
import com.example.projetspringboot.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EtudiantService implements  IEtudiantService{
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    DepartementRepository departementRepository;
    public List<Etudiant> findAll()
    {
        return etudiantRepository.findAll();
    }
    public Etudiant findByIdEtudiant(Long id)
    {
        Etudiant etudiant = etudiantRepository.findByIdEtudiant(id);
        return etudiant;
    }

    public Etudiant addEtudiant(Etudiant c) {

        Etudiant co = etudiantRepository.save(c);
        return c;
    }
    public void DeleteEtudiant(Long id) {

        etudiantRepository.deleteById(id);

    }

    public Etudiant updateEtudiant(Long id , Etudiant e) {

        Etudiant eq = etudiantRepository.findByIdEtudiant(id);
        eq.setIdEtudiant(id);
        eq.setContrats(e.getContrats());
        eq.setOption(e.getOption());
        eq.setEquipes(e.getEquipes());
        eq.setNomE(e.getNomE());
        eq.setDepartement(e.getDepartement());
        eq.setPrenomE(e.getPrenomE());
        etudiantRepository.save(eq);
        return eq;

    }

    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe)
    {
        etudiantRepository.save(e);
        Equipe eq = equipeRepository.findByIdEquipe(new Long(idEquipe));
        Contrat c = contratRepository.findByIdContrat(new Long(idContrat));
        eq.getEtudiants().add(e);
        equipeRepository.save(eq);
        c.setEtudiant(e);
        contratRepository.save(c);
        return e;
    }
    public Contrat affectContratToEtudiant (Integer idContrat,String nomE,String prenomE)
    {
        Etudiant e1 = etudiantRepository.findByNomE(nomE);
        Etudiant e2 = etudiantRepository.findByPrenomE(prenomE);
        if(e1==e2){
            Contrat c1 = contratRepository.findByIdContrat(new Long(idContrat));
            e1.getContrats().add(c1);
            etudiantRepository.save(e1);
            c1.setEtudiant(e1);
            contratRepository.save(c1);
            return c1;
        }
        else return null;

    }

    public Set<Etudiant> getEtudiantsByDepartement(Integer idDepartement)
    {
        return departementRepository.findAllByIdDepart(new Long(idDepartement)).getEtudiants();

    }

}
