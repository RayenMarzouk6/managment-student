package com.example.projetspringboot.service;

import com.example.projetspringboot.entities.AppRole;
import com.example.projetspringboot.entities.AppUser;
import com.example.projetspringboot.repository.AppRoleREpository;
import com.example.projetspringboot.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AppUserRepository appUSerRepository;
    @Autowired
    private AppRoleREpository appRoleREpository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmPassword){
        AppUser appUser=appUSerRepository.findByUserName(username);
        if(appUser!=null) throw new RuntimeException("user déja existant");
        if (!password.equals(confirmPassword)) throw new RuntimeException("password incorrect");
        appUser= com.example.projetspringboot.entities.AppUser.builder()
            .userId(UUID.randomUUID().toString())
            .userName(username)
                .password(passwordEncoder.encode(password))
                .build();
        AppUser saveAppUser= appUSerRepository.save(appUser);
    return saveAppUser;
    }
    @Override
    public AppRole addNewRole(String role){
        AppRole appRole=appRoleREpository.findById(role).orElse(null);
        if(appRole!=null) throw new RuntimeException("role déja existant");
        appRole=AppRole.builder()
                .role(role)
                .build();
        return appRoleREpository.save(appRole);

    }
    @Override
    public void addRoleToUSer(String username,String role){

        AppUser appuser=appUSerRepository.findByUserName(username);
        AppRole appRole=appRoleREpository.findById(role).get();
        appuser.getRoles().add(appRole);

    }
    @Override
    public void removeRoleFRomUSer(String username,String role){
        AppUser appuser=appUSerRepository.findByUserName(username);
        AppRole appRole=appRoleREpository.findById(role).get();
        appuser.getRoles().remove(appRole);
    }
    public AppUser loadUserByUsername(String username){
  return appUSerRepository.findByUserName(username);
    }
}
