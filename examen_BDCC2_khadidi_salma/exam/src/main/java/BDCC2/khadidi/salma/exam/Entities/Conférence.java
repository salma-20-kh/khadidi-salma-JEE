package BDCC2.khadidi.salma.exam.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Conférence {
    @Id
    private String id;
    private String titre;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "hh:mm::ss")
    private Date heureDébut;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "hh:mm::ss")
    private Date heureFin;
    private String description;
    @ManyToOne
    private Speaker speaker;
    @ManyToOne
    private Session session;
    @OneToMany(mappedBy = "conférence",fetch = FetchType.LAZY)
    private List<Commentaire> commentaireList;
    @OneToMany(mappedBy = "conférence",fetch = FetchType.LAZY)
    private List<Invité> invitéList;
}
