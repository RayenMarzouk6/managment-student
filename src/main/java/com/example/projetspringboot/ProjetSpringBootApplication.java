package com.example.projetspringboot;

import com.example.projetspringboot.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
public class ProjetSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetSpringBootApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunnerUserDetails(AccountService accountService){
        return args-> {
            accountService.addNewRole("USER");
            accountService.addNewRole("ADMIN");
            accountService.addNewUser("user1", "1234", "user1@gmail.com", "1234");
            accountService.addNewUser("user2", "1234", "user2@gmail.com", "1234");
            accountService.addNewUser("admin", "1234", "admin@gmail.com", "1234");
            accountService.addRoleToUSer("user1","USER");
            accountService.addRoleToUSer("user2","USER");
            accountService.addRoleToUSer("admin","USER");
            accountService.addRoleToUSer("admin","Admin");
        };
    }
    @Bean
  PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
  }
}
