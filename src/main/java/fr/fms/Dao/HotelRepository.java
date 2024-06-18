package fr.fms.Dao;

import fr.fms.entity.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel , Long>
{
    List<Hotel> findByCityId(Long cityId);
    List<Hotel> findByNameContains(String description);
}
