package fr.fms.Service;

import fr.fms.Dao.GerantRepository;
import fr.fms.Dao.ManagerRepository;
import fr.fms.Dao.RoleRepository;
import fr.fms.Dao.UserRepository;
import fr.fms.entity.Gerant;
import fr.fms.entity.Manager;
import fr.fms.entity.Role;
import fr.fms.entity.appUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service @Transactional @Slf4j
public class AccountServiceImpl implements AccountService
{
    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    GerantRepository gerantRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public Gerant findGerantByName(String username) {
        return gerantRepository.findByName(username);
    }

    @Override
    public Manager findManagerByName(String username) {
        return managerRepository.findByName(username);
    }

    @Override
    public appUser findUserByName(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public void addRoleToManager(String username, String rolename) {
        Role role = roleRepository.findByRolename(rolename);
        Manager user = managerRepository.findByName(username);
        user.getRoles().add(role);
    }

    @Override
    public void addRoleToGerant(String username, String rolename) {
        Role role = roleRepository.findByRolename(rolename);
        Gerant user = gerantRepository.findByName(username);
        user.getRoles().add(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        Role role = roleRepository.findByRolename(rolename);
        appUser user = userRepository.findByName(username);
        user.getRoles().add(role);
    }

}
