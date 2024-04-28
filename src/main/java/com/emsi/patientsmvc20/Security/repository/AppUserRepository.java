package com.emsi.patientsmvc20.Security.repository;

import com.emsi.patientsmvc20.Security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
