package fr.fms.Dao;

import fr.fms.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role , Long>
{
    Role findByRolename(String rolename);
}
