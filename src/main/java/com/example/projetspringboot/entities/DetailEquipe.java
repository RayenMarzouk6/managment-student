package com.example.projetspringboot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name="DetailEquipe")
@Setter
@Getter
@ToString
public class DetailEquipe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idDetailEquipe")
    private Long idDetailEquipe ;
    private Long salle ;
    private String thematique;
    @OneToOne(mappedBy = "detailEquipe")
    private Equipe equipe;

    public DetailEquipe() {
    }

    public DetailEquipe(Long idDetailEquipe, Long salle, String thematique) {
        this.idDetailEquipe = idDetailEquipe;
        this.salle = salle;
        this.thematique = thematique;
    }


}
