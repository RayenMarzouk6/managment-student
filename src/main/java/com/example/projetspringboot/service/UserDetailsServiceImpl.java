package com.example.projetspringboot.service;

import com.example.projetspringboot.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        AppUser appUser = accountService.loadUserByUsername(username);

        if(appUser==null) throw new UsernameNotFoundException(String.format("USER %s n'existe pas",username));

        String[] roles = appUser.getRoles().stream().map(u -> u.getRole()).toArray(String[]::new);
         UserDetails userDetails = User
               .withUsername(appUser.getUserName())
               .password(appUser.getPassword())
               .roles(roles).build();
        return userDetails;
    }
}
