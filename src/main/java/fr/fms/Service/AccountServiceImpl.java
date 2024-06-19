package fr.fms.Service;

import fr.fms.Dao.RoleRepository;
import fr.fms.Dao.UserRepository;
import fr.fms.entity.appRole;
import fr.fms.entity.appUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional @Slf4j
public class AccountServiceImpl implements AccountService
{

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public appUser getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public appUser saveUser(appUser user) {
        String hashPw = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPw);
        log.info("sauvegarde d'un utilisateur {} en base", user);
        return userRepository.save(user);
    }

    @Override
    public appRole saveRole(appRole role) {
        log.info("sauvergarde d'un nouveau role en base");
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        appRole role = roleRepository.findByRolename(rolename);
        appUser user = userRepository.findByUsername(username);
        user.getAppRoles().add(role);
        log.info("association d'un role à un utilisateur");
    }

    @Override
    public appUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public ResponseEntity<List<appUser>> listUser() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }
}
