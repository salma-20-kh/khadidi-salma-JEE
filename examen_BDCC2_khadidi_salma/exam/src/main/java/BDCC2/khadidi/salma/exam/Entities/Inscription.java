package BDCC2.khadidi.salma.exam.Entities;

import BDCC2.khadidi.salma.exam.Enums.InscriptionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Enumerated(EnumType.STRING)
    private InscriptionStatus statut;
    private Double prix;
    @ManyToOne
    private Invité invité;
    @ManyToOne
    private Session session;

}
