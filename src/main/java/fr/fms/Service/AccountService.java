package fr.fms.Service;

import fr.fms.entity.Gerant;
import fr.fms.entity.Manager;
import fr.fms.entity.appUser;

public interface AccountService
{
    void addRoleToManager(String username, String role);
    void addRoleToGerant(String username, String role);
    void addRoleToUser(String username, String role);
    Gerant findGerantByName(String username);
    Manager findManagerByName(String username);
    appUser findUserByName(String username);
}
