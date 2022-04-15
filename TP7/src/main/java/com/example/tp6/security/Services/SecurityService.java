package com.example.tp6.security.Services;

import com.example.tp6.security.Entities.AppRole;
import com.example.tp6.security.Entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePassword);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void RemoveRoleFromUser(String username, String roleName);
    AppUser loadUserByUserName(String username);
}
