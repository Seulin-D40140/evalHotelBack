package fr.fms.Dao;

import fr.fms.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City , Long> {
}
