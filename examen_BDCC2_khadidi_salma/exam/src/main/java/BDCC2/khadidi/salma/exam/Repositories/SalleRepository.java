package BDCC2.khadidi.salma.exam.Repositories;

import BDCC2.khadidi.salma.exam.Entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends JpaRepository<Salle, String> {
}
