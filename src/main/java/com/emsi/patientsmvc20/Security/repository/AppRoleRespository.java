package com.emsi.patientsmvc20.Security.repository;

import com.emsi.patientsmvc20.Security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRespository extends JpaRepository<AppRole,String> {
}
