package com.example.projetspringboot.DAO;

import com.example.projetspringboot.entities.Departement;
import com.example.projetspringboot.entities.Universite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class departdetails {
    private Departement depart;
    private Universite univ;
}
