package fr.fms.service;

import fr.fms.entity.City;
import fr.fms.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService
{
    List<Hotel> getHotels();
    Hotel saveHotel(Hotel hotel);
    List<City> getCitys();
    City saveCity(City city);
    Optional<City> findCityById(Long id);
    List<Hotel> getHotelByCity(Long id);
    Optional<Hotel> getHotelByid(Long id);
    List<Hotel> getByNameContains(String description);
    void deleteHotel(Long id);
}
