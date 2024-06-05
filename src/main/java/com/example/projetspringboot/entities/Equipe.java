package com.example.projetspringboot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Equipe")
@Setter
@Getter
@ToString
public class Equipe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")
    private Long idEquipe ;
    private String nomEquipe ;
    @Enumerated(EnumType.STRING)
    private Niveau niveau ;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "equipes")
    private Set<Etudiant> etudiants;
    @OneToOne
    private DetailEquipe detailEquipe;
    @ManyToOne
    private Entreprise entreprise;

    public Equipe() {

    }

    public Equipe(Long idEquipe, String nomEquipe, Niveau niveau) {
        this.idEquipe = idEquipe;
        this.nomEquipe = nomEquipe;
        this.niveau = niveau;
    }

    public Equipe(Long idEquipe, String nomEquipe) {
        this.idEquipe = idEquipe;
        this.nomEquipe = nomEquipe;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        niveau = niveau;
    }
}
