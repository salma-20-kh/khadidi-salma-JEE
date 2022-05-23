package BDCC2.khadidi.salma.exam.Entities;

import BDCC2.khadidi.salma.exam.Enums.participantGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 10)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String photo;
    @Enumerated(EnumType.STRING)
    private participantGenre genre;

}
