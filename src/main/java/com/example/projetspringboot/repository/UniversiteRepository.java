package com.example.projetspringboot.repository;

import com.example.projetspringboot.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
    public Universite findByIdUniv(Long id);
}
