package com.example.projetspringboot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name="Departement")
@Setter
@Getter
@ToString

public class Departement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDepart")
    private Long idDepart;
    private String nomDepart;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departement")
    private Set<Etudiant> Etudiants;

    public Departement() {

    }

    public Departement(Long idDepart, String nomDepart) {
        this.idDepart = idDepart;
        this.nomDepart = nomDepart;
    }


}
