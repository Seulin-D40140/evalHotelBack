package fr.fms.Service;

import fr.fms.entity.Gerant;
import fr.fms.entity.Manager;

public interface AccountService
{
    void addRoleToManager(String username, String role);
    void addRoleToGerant(String username, String role);
    Gerant findGerantByName(String username);
    Manager findManagerByName(String username);
}
