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
@DiscriminatorValue("Speaker")
@AllArgsConstructor
@NoArgsConstructor
public class Speaker extends Participant {
    private String profilPersonnel;
    @OneToMany(mappedBy = "speaker",fetch = FetchType.LAZY)
    private List<Conférence> conférences;
}
