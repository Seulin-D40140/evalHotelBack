package fr.fms.Service;

import fr.fms.Dao.CityRepository;
import fr.fms.Dao.HotelRepository;
import fr.fms.entity.City;
import fr.fms.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService
{
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<Hotel> getHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public List<City> getCitys() {
        return cityRepository.findAll();
    }
}
