package fr.fms.Dao;


import fr.fms.entity.appUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<appUser, Long>
{
    appUser findByUsername(String rolename);
}
