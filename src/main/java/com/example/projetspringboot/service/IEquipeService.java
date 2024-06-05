package com.example.projetspringboot.service;



import com.example.projetspringboot.entities.Equipe;

import java.util.List;

public interface IEquipeService {
    public List<Equipe> findAllBy();
    public Equipe findByIdEquipe(Long id);
    public Equipe addEquipe(Equipe e);
    public void DeleteEquipe(Long id);
    public Equipe updateEquipe(Long id , Equipe e);
    public void faireEvoluerEquipes();
}
