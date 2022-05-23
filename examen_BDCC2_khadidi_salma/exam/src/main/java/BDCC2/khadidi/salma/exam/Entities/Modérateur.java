package BDCC2.khadidi.salma.exam.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@DiscriminatorValue("Modérateur")
@AllArgsConstructor
@NoArgsConstructor
public class Modérateur extends Participant {
    private String specialite;
    @OneToMany(mappedBy = "modérateur",fetch = FetchType.LAZY)
    private List<Session> sessions;
}
