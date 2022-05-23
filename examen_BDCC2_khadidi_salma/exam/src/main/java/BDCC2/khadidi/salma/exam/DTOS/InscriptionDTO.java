package BDCC2.khadidi.salma.exam.DTOS;

import BDCC2.khadidi.salma.exam.Entities.Invité;
import BDCC2.khadidi.salma.exam.Entities.Session;
import BDCC2.khadidi.salma.exam.Enums.InscriptionStatus;
import lombok.Data;

import java.util.Date;

@Data
public class InscriptionDTO {
    private Long id;
    private Date date;
    private InscriptionStatus statut;
    private Double prix;
    private Invité invité;
    private Session session;

}
