package com.emsi.patientsmvc20.Security.service;

import com.emsi.patientsmvc20.Security.entities.AppRole;
import com.emsi.patientsmvc20.Security.entities.AppUser;

public interface AccountService {
    public AppUser addNewUser(String username,String password,String email,String confirmPassword);
    public AppRole addNewRole(String role);
    void addRoleToUser(String username,String role);
    void removeRoleFromUser(String username,String role);
    AppUser loadUserByUserName(String username);

}
