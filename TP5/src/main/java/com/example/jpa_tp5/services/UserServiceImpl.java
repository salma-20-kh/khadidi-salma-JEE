package com.example.jpa_tp5.services;

import com.example.jpa_tp5.entites.Role;
import com.example.jpa_tp5.entites.User;
import com.example.jpa_tp5.repositories.RoleRepository;
import com.example.jpa_tp5.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional @AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @Override
    public User addNewUser(User user) {
        user.setUserID(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        //role.setId(UUID.randomUUID().getMostSignificantBits());
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user); // pour être plus correcte en POO
        }
        //userRepository.save(user); //c'est pas nécessaire, la transaction fait le job elle-même
    }

    @Override
    public User authenticate(String userName, String password) {
        User user = userRepository.findByUserName(userName);
        if(user == null){
            throw new RuntimeException("Bad Credentials");
        }
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad Credentials");
    }
}
