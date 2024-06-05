package com.example.projetspringboot.repository;

import com.example.projetspringboot.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUserName(String username);
}
