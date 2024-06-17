package fr.fms.Dao;

import fr.fms.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel , Long> {
}
