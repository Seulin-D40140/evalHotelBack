package fr.fms.Dao;

import fr.fms.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager , Long>
{
    Manager findByName(String rolename);
}
