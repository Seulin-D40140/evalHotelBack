package fr.fms.Web;

import fr.fms.Service.AccountServiceImpl;
import fr.fms.entity.appUser;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class AccountControler {

    @Autowired
    AccountServiceImpl accountService;

    @GetMapping("/users")
    ResponseEntity<List<appUser>> getUsers(){
        return this.accountService.listUser();
    }

//    @PostMapping("/users")
//    public appUser postUser(@RequestBody appUser user){
//        return this.accountService.saveUser(user);
//    }
//
//    @PostMapping("/roles")
//    public Role postRole(@RequestBody Role role){
//        return this.accountService.saveRole(role);
//    }

    @PostMapping("/roleUser")
    public void postRoleToUser(@RequestBody UserRoleForm userRoleForm){
        accountService.addRoleToUser(userRoleForm.getUsername(), userRoleForm.getRolename());
    }
}

@Data
class UserRoleForm{
    private String username;
    private String rolename;
}