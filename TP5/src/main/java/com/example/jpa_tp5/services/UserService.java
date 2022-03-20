package com.example.jpa_tp5.services;

import com.example.jpa_tp5.entites.Role;
import com.example.jpa_tp5.entites.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String username);
    Role findRoleByRoleName(String rolename);
    void addRoleToUser(String username, String roleName);  // l'importance de l'unicité des arguments
    User authenticate(String userName, String password);
}
