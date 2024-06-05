package com.example.projetspringboot.DAO;

import com.example.projetspringboot.entities.Option;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EtudiantDAO {
    private  Long idEtudiant;
    private String prenomE;
    private String nomE;
    private Option option;
}
