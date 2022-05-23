package BDCC2.khadidi.salma.exam.security.Services;

import soukaina.elkamouni.examenjee.security.Entities.AppRole;
import soukaina.elkamouni.examenjee.security.Entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePassword);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void RemoveRoleFromUser(String username, String roleName);
    AppUser loadUserByUserName(String username);
}
