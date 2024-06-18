package fr.fms.Service;

import fr.fms.entity.City;
import fr.fms.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService
{
    List<Hotel> getHotels();
    List<City> getCitys();
    List<Hotel> getHotelByCity(Long id);
    Optional<Hotel> getHotelByid(Long id);
    List<Hotel> getByNameContains(String description);
}
