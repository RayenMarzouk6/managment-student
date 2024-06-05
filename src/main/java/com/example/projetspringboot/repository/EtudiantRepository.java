package com.example.projetspringboot.repository;


import com.example.projetspringboot.entities.Etudiant;
import com.example.projetspringboot.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    public  List<Etudiant> findByDepartementIdDepart(Long id);
    public List<Etudiant>  findByEquipesIdEquipeAndEquipesNiveau(Long id, Niveau niveau);
    public Etudiant findByIdEtudiant(Long id);
    public Etudiant findByNomE(String nom);
    public Etudiant findByPrenomE(String prenom);



   /* @Modifying b
    @Query(  value ="INSERT INTO Etudiant(e) values (:e) AND INSERT INTO Equipe.etudiants values (:e) AND INSERT INTO Contrat.etudiant values (:e)",
            nativeQuery = true)
    Etudiant addAndAssignEtudiantToEquipeAndContract(@Param("e")Etudiant e,@Param("idContrat") Integer idContrat,@Param("idEquipe") Integer idEquipe);
*/
    //public Etudiant findByNomEAndPrenomE(String NomE , String PrenomE);

    //SQL
   /* @Query(
            value ="SELECT e FROM Etudiant e HAVING Contrat.etudiant.idEtudiant=e.idEtudiant and Contrat.specialite =: specialite",
            nativeQuery = true)
    List<Etudiant> retrieveEtudiantBySpecialiteSQL(@Param("specialite") String specialite);*/

    //JPQL
/*@Query("SELECT e FROM Etudiant e HAVING Contrat.etudiant.idEtudiant=e.idEtudiant and Contrat.specialite =: specialite")
List<Etudiant> retrieveEtudiantBySpecialiteJPQL(@Param("specialite") String specialite);*/
}
