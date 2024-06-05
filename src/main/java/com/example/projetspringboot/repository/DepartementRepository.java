package com.example.projetspringboot.repository;



import com.example.projetspringboot.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {

        public Departement findAllByIdDepart(Long id);



}
