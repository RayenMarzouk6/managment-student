package com.example.projetspringboot.repository;


import com.example.projetspringboot.entities.DetailEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailEquipeRepository extends JpaRepository<DetailEquipe, Long> {

        public DetailEquipe findByIdDetailEquipe(Long id);
        }
