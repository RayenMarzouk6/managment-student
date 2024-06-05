package com.example.projetspringboot.service;


import com.example.projetspringboot.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> findAll();

    public Universite findByIdUniversite(Long id);

    public Universite addUniversite(Universite c);
    public void DeleteUniversite(Long id);

    public Universite updateUniversite(Long id , Universite e);
}
