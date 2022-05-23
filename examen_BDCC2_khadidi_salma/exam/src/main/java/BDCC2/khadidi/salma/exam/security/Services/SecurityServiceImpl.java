package BDCC2.khadidi.salma.exam.security.Services;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soukaina.elkamouni.examenjee.security.Entities.AppRole;
import soukaina.elkamouni.examenjee.security.Entities.AppUser;
import soukaina.elkamouni.examenjee.security.Repositories.AppRoleRepository;
import soukaina.elkamouni.examenjee.security.Repositories.AppUserRepository;

import java.util.UUID;

@Service
@Slf4j // pour loguer les informations
@Transactional // faire attention d'utiliser celle de spring
public class SecurityServiceImpl implements SecurityService {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    //private PasswordEncoder passwordEncoder;

    public SecurityServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public AppUser saveNewUser(String username, String password, String rePassword) {
        if (!password.equals(rePassword)) throw new RuntimeException("mot de pass incorrect");
        AppUser appUser = new AppUser();
        appUser.setUserId(UUID.randomUUID().toString());
        appUser.setUsername(username);
        appUser.setPassword(UUID.randomUUID().toString());
        appUser.setActive(true);
        AppUser savedAppUser = appUserRepository.save(appUser);
        return savedAppUser;
    }

    @Override
    public AppRole saveNewRole(String roleName, String description) {
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appRole!=null) throw new RuntimeException("Role "+roleName+" Already exist");
        appRole=new AppRole();
        appRole.setRoleName(roleName);
        appRole.setDescription(description);
        AppRole savedAppRole = appRoleRepository.save(appRole);
        return savedAppRole;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser==null) throw new RuntimeException("User Not Found");
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appRole==null) throw new RuntimeException("Role Not Found");
        appUser.getAppRoles().add(appRole);
        //appUserRepository.save(appUser);
    }

    @Override
    public void RemoveRoleFromUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser==null) throw new RuntimeException("User Not Found");
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if (appRole==null) throw new RuntimeException("Role Not Found");
        appUser.getAppRoles().remove(appRole);

    }

    @Override
    public AppUser loadUserByUserName(String username) {
        return appUserRepository.findByUsername(username);
    }
}
