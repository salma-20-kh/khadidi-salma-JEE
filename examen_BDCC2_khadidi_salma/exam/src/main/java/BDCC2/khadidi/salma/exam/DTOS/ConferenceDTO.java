package BDCC2.khadidi.salma.exam.DTOS;

import lombok.Data;
import java.util.Date;

@Data
public class ConferenceDTO {
    private String id;
    private String titre;
    private Date date;
    private Date heureDébut;
    private Date heureFin;
    private String description;
    private SpeakerDTO speaker;
}
