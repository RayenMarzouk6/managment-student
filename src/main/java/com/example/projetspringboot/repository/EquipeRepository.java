package com.example.projetspringboot.repository;


import com.example.projetspringboot.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    public List<Equipe> findAllBy();
    public Equipe findByIdEquipe(Long id);

   /* @Modifying
    @Query(value="INSERT INTO Equipe(idEquipe,nomEquipe,niveau) VALUES (:id,:nom,:niv)",
            nativeQuery = true)
    public Equipe addEquipe(@Param("id") Long id,@Param("nom")  String nom,@Param("niv")  Niveau niv );*/
}