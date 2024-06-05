package com.example.projetspringboot.service;



import com.example.projetspringboot.entities.Departement;
import com.example.projetspringboot.entities.Etudiant;
import com.example.projetspringboot.entities.Universite;
import com.example.projetspringboot.repository.DepartementRepository;
import com.example.projetspringboot.repository.EtudiantRepository;
import com.example.projetspringboot.repository.UniversiteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DepartementService implements IDepartementService {
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    UniversiteRepository universiteRepository;

    public List<Departement> findAll()
    {
        return departementRepository.findAll();
    }

    public Departement findByIdDepartement(Long id)
    {
        Departement departement = departementRepository.findAllByIdDepart(id);
        return departement;
    }

    public Departement addDepartement(Departement d) {

        Departement de = departementRepository.save(d);
        return d;
    }
    public void DeleteDepartement(Long id) {

        departementRepository.deleteById(id);

    }

    public Departement updateDepartement(Long id , Departement e) {

        Departement eq = departementRepository.findAllByIdDepart(id);
        eq.setIdDepart(id);
        eq.setEtudiants(e.getEtudiants());
        eq.setNomDepart(e.getNomDepart());
        departementRepository.save(eq);
        return eq;

    }

    public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId)
    {
        Etudiant e = etudiantRepository.findByIdEtudiant(new Long(etudiantId));
        Departement d= departementRepository.findAllByIdDepart(new Long(departementId));
       d.getEtudiants().add(e);
       e.setDepartement(d);
       etudiantRepository.save(e);
       departementRepository.save(d);
    }

    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement)
    {
        Universite u = universiteRepository.findByIdUniv(new Long(idUniversite));
        Departement d= departementRepository.findAllByIdDepart(new Long(idDepartement));
        u.getDepartements().add(d);
        universiteRepository.save(u);
    }

    public Set<Departement> retrieveDepartementsByUniversite(Integer idUniversite)
    {
      Universite uv =   universiteRepository.findByIdUniv(new Long(idUniversite));
      return uv.getDepartements();
    }
    @PersistenceContext
    private EntityManager entityManager;

    public Universite getUniversiteByDepartementId(Long departementId) {
        String sqlQuery = "SELECT u.* FROM universite u  " +
                "INNER JOIN universite_departements d ON u.id_univ = d.universite_id_univ " +
                "WHERE d.departements_id_depart = :departementId";
        System.out.println("SQL Query: " + sqlQuery);
        Query query = entityManager.createNativeQuery(sqlQuery, Universite.class);
        query.setParameter("departementId", departementId);

        try {
            return (Universite) query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
}
