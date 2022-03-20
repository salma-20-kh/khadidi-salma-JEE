package com.example.jpa_tp5.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(schema = "users")
@Table(name = "USERS")
@Data @AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    private String UserID;
    @Column(name = "USER_NAME", unique = true,length = 20) // c'est un index unique
    private String Username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();
}
