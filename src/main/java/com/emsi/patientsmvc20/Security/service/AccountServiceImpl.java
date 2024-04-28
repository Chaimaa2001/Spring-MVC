package com.emsi.patientsmvc20.Security.service;

import com.emsi.patientsmvc20.Security.entities.AppRole;
import com.emsi.patientsmvc20.Security.entities.AppUser;
import com.emsi.patientsmvc20.Security.repository.AppRoleRespository;
import com.emsi.patientsmvc20.Security.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Encoder;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor

public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRespository appRoleRespository;
    private PasswordEncoder passwordEncoder;



    @Override
    public AppUser addNewUser(String username, String password, String email, String confirmPassword) {

        AppUser appUser=appUserRepository.findByUsername(username);
        if(appUser!=null) throw new RuntimeException("this user already exits");
        if(!password.equals(confirmPassword)) throw new RuntimeException(("Password not match"));
        appUser =AppUser.builder()
                .userId(UUID.randomUUID().toString())
                .username(username)
                .password(passwordEncoder.encode((password)))
                .email(email)
                .build();
        AppUser savedAppUser= appUserRepository.save(appUser);
        return savedAppUser;
    }

    @Override
    public AppRole addNewRole(String role) {
        AppRole appRole=appRoleRespository.findById(role).orElse(null);
        if(appRole!=null) throw new RuntimeException(("THis role already exists"));
        appRole=AppRole.builder()
                .role(role)
                .build();
        return appRoleRespository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRespository.findById(role).get();
        appUser.getRoles().add(appRole);
        //appUserRepository.save(appUser);

    }

    @Override
    public void removeRoleFromUser(String username, String role) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRespository.findById(role).get();
        appUser.getRoles().remove(appRole);

    }

    @Override
    public AppUser loadUserByUserName(String username) {
        return appUserRepository.findByUsername(username);
    }


}
