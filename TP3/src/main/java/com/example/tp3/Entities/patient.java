package com.example.tp3.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data // generer getters et setters ,lombok qui fait ça
@NoArgsConstructor //constructeur sans parametres
@AllArgsConstructor // constructeur avec parametres
@Entity //pour creer une entité JPA
public class patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOM",length = 50)// dans la base de données ,la column correspondante à cette attribut sera nommé NOM et de taille 50
    private String nom;
    @Temporal(TemporalType.DATE)// dans la base de données garder que la date(dd/mm/yyyy)
    private Date dateNaissance;
    private Boolean malade;
    private int score;

}
