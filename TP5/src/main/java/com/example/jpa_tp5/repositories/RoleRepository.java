package com.example.jpa_tp5.repositories;

import com.example.jpa_tp5.entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
