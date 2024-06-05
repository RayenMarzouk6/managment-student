package com.example.projetspringboot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name="Etudiant")
@Setter
@Getter
@ToString
public class Etudiant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private  Long idEtudiant;
 private String prenomE;
 private String nomE;
 @Enumerated(EnumType.STRING)
 private Option option;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Equipe> equipes;
    @ManyToOne
    private Departement departement;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
    private Set<Contrat> contrats;

    public Etudiant(Set<Contrat> contrats) {
        this.contrats = contrats;
    }

    public Etudiant() {

    }

    public Etudiant(Long idEtudiant, String prenomE, String nomE) {
        this.idEtudiant = idEtudiant;
        this.prenomE = prenomE;
        this.nomE = nomE;
    }

    public Etudiant(Long idEtudiant, String prenomE, String nomE, Option option, Set<Equipe> equipes, Departement departement, Set<Contrat> contrats) {
        this.idEtudiant = idEtudiant;
        this.prenomE = prenomE;
        this.nomE = nomE;
        this.option = option;
        this.equipes = equipes;
        this.departement = departement;
        this.contrats = contrats;
    }


}
