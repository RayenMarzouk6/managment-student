package com.example.projetspringboot.service;

import com.example.projetspringboot.entities.Contrat;
import com.example.projetspringboot.entities.Equipe;
import com.example.projetspringboot.entities.Etudiant;
import com.example.projetspringboot.entities.Niveau;
import com.example.projetspringboot.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService implements IEquipeService {

    @Autowired
    EquipeRepository equipeRepository;

    public List<Equipe> findAllBy() {
        return equipeRepository.findAllBy();
    }

    public Equipe findByIdEquipe(Long id) {
        /*return equipes.stream()
                .filter(equipe -> equipe.getIdEquipe().equals(id))
                .findAny()
                .orElse(null);*/
        Equipe equipe = equipeRepository.findByIdEquipe(id);
        return equipe;
    }

    public Equipe addEquipe(Equipe e) {
     /*  Equipe equipe = new Equipe(id,nom,niv);
        EquipeRepository.
        equipes.add(equipe);
        return equipe;*/
        Equipe eq = equipeRepository.save(e);
        return e;

    }

    public void DeleteEquipe(Long id) {

        equipeRepository.deleteById(id);

    }

    public Equipe updateEquipe(Long id, Equipe e) {

        Equipe eq = equipeRepository.findByIdEquipe(id);
        eq.setIdEquipe(id);
        eq.setNomEquipe(e.getNomEquipe());
        eq.setNiveau(e.getNiveau());
        eq.setEtudiants(e.getEtudiants());
        eq.setDetailEquipe(e.getDetailEquipe());
        eq.setEntreprise(e.getEntreprise());
        equipeRepository.save(eq);
        return eq;

    }

    public void faireEvoluerEquipes() {
        int compteur = 0;
        List<Equipe> eq = equipeRepository.findAllBy();
        for (Equipe e : eq) {
            for (Etudiant i : e.getEtudiants()) {
                for (Contrat c : i.getContrats()) {
                    // calculer la difference de jour entre date fin et debut et copmarer a 1ans (365jours)
                    if ((((c.getDateFinContrat().getTime() - c.getDateDebutContrat().getTime()) / (1000 * 60 * 60 * 24)) > 365) && (e.getNiveau() == Niveau.JUNIOR || e.getNiveau() == Niveau.SINIOR)) {
                        compteur = compteur + 1;
                        //3 membres
                        if (compteur == 3) {
                            if (e.getNiveau() == Niveau.JUNIOR) {
                                e.setNiveau(Niveau.SINIOR);
                            }
                            if (e.getNiveau() == Niveau.SINIOR) {
                                e.setNiveau(Niveau.EXPERT);
                            }
                        }
                    }
                }
            }
        }
    }
}
