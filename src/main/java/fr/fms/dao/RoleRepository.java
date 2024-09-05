package fr.fms.dao;

import fr.fms.entity.appRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<appRole, Long>
{
    appRole findByRolename(String rolename);
}
