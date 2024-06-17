package fr.fms.Dao;

import fr.fms.entity.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerantRepository extends JpaRepository<Gerant , Long>
{
    Gerant findByName(String rolename);
}
