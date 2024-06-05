package com.example.projetspringboot.repository;


import com.example.projetspringboot.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {

        public Contrat findByIdContrat(Long id) ;



}
