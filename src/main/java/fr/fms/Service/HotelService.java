package fr.fms.Service;

import fr.fms.entity.City;
import fr.fms.entity.Hotel;

import java.util.List;

public interface HotelService
{
    List<Hotel> getHotels();
    List<City> getCitys();
}
