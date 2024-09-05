package fr.fms.dao;

import fr.fms.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel , Long>
{
    List<Hotel> findByCityId(Long cityId);
    List<Hotel> findByNameContains(String description);
}
