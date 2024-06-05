package com.example.projetspringboot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Universite")
@Setter
@Getter
@ToString
public class Universite implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUniv")
    private Long idUniv;
    private String nomUniv;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> departements;

    public Universite(){

    }

    public Universite(Long idUniv, String nomUniv) {
        this.idUniv = idUniv;
        this.nomUniv = nomUniv;
    }


    public Universite(Long idDepart, String nomDepart, Long idUniv, String nomUniv) {
        this.idUniv = idUniv;
        this.nomUniv = nomUniv;
    }



}
