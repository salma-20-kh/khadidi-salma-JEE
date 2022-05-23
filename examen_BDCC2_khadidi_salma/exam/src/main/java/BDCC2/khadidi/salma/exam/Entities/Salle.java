package BDCC2.khadidi.salma.exam.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id ;
   private String nom;
   @OneToMany(mappedBy = "salle",fetch = FetchType.LAZY)
   private List<Session> sessionList;
}
