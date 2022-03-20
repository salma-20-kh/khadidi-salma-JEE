package com.example.jpa_tp5.repositories;

import com.example.jpa_tp5.entites.Role;
import com.example.jpa_tp5.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName(String username);
}
