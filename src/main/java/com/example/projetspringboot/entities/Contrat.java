package com.example.projetspringboot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Contrat")
@Setter
@Getter
@ToString
public class Contrat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private Long idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    public Specialite specialite ;
    private Boolean archive ;
    private Long montantContrat ;
    @ManyToOne
    private Etudiant etudiant;

    public Contrat() {
    }

    public Contrat(Long idContrat, Long montantContrat) {
        this.idContrat = idContrat;
        this.montantContrat = montantContrat;
    }

    public Contrat(Long idContrat, Date dateDebutContrat, Date dateFinContrat, Specialite specialite, Boolean archive, Long montantContrat) {
        this.idContrat = idContrat;
        this.dateDebutContrat = dateDebutContrat;
        this.dateFinContrat = dateFinContrat;
        this.specialite = specialite;
        this.archive = archive;
        this.montantContrat = montantContrat;
    }

}
