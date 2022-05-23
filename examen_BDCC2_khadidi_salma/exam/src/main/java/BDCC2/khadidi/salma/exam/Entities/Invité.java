package BDCC2.khadidi.salma.exam.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @DiscriminatorValue("Invité")
@AllArgsConstructor
@NoArgsConstructor
public class Invité extends Participant {
    private String affiliation;
    @OneToMany(mappedBy = "invité",fetch = FetchType.LAZY)
    private List<Inscription> inscriptionList;
    @ManyToOne
    private Conférence conférence;
}
