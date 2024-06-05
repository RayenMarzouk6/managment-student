package com.example.projetspringboot.repository;

import com.example.projetspringboot.entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    public Entreprise findByIdEntreprise(Long id);

}
