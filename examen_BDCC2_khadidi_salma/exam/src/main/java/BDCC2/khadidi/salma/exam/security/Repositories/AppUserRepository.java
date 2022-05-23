package BDCC2.khadidi.salma.exam.security.Repositories;

import BDCC2.khadidi.salma.exam.security.Entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
