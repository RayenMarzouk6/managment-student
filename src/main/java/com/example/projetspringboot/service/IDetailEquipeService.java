package com.example.projetspringboot.service;



import com.example.projetspringboot.entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {
    public List<DetailEquipe> findAll();

    public DetailEquipe findByIdDetailEquipe(Long id);

    public DetailEquipe addDetailEquipe(DetailEquipe c);
    public void DeletedetailEquipe(Long id);

    public DetailEquipe updateDetailEquipe(Long id , DetailEquipe e);
}
