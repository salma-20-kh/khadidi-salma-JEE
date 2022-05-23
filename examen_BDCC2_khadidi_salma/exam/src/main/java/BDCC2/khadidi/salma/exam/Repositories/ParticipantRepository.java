package BDCC2.khadidi.salma.exam.Repositories;

import BDCC2.khadidi.salma.exam.Entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
