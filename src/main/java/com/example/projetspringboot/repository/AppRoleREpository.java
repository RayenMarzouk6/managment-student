package com.example.projetspringboot.repository;

import com.example.projetspringboot.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleREpository extends JpaRepository<AppRole,String> {
}
