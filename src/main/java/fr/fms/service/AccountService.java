package fr.fms.service;

import fr.fms.entity.appRole;
import fr.fms.entity.appUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService
{
    appUser getUserByUsername(String username);

    appUser saveUser(appUser user);
    appRole saveRole(appRole role);
    void addRoleToUser(String username, String rolename);
    appUser findUserByUsername(String username);
    ResponseEntity<List<appUser>> listUser();
}
