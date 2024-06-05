package com.example.projetspringboot.service;

import com.example.projetspringboot.entities.DetailEquipe;
import com.example.projetspringboot.repository.DetailEquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailEquipeService implements IDetailEquipeService{
    @Autowired
    DetailEquipeRepository detailEquipeRepository;
    public List<DetailEquipe> findAll()
    {
        return detailEquipeRepository.findAll();
    }

    public DetailEquipe findByIdDetailEquipe(Long id)
    {
        DetailEquipe detailEquipe = detailEquipeRepository.findByIdDetailEquipe(id);
        return detailEquipe;
    }

    public DetailEquipe addDetailEquipe(DetailEquipe c) {

        DetailEquipe co = detailEquipeRepository.save(c);
        return c;
    }
    public void DeletedetailEquipe(Long id) {

        detailEquipeRepository.deleteById(id);

    }

    public DetailEquipe updateDetailEquipe(Long id , DetailEquipe e) {

        DetailEquipe eq = detailEquipeRepository.findByIdDetailEquipe(id);
        eq.setIdDetailEquipe(id);
        eq.setEquipe(e.getEquipe());
        eq.setSalle(e.getSalle());
        eq.setThematique(e.getThematique());
        detailEquipeRepository.save(eq);
        return eq;

    }
}
