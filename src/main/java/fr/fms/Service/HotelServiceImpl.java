package fr.fms.Service;

import fr.fms.Dao.CityRepository;
import fr.fms.Dao.HotelRepository;
import fr.fms.entity.City;
import fr.fms.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return cityRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Optional<City> findCityById(Long id) { return cityRepository.findById(id); }

    @Override
    public  List<Hotel> getHotelByCity(Long id) { return hotelRepository.findByCityId(id); }

    @Override
    public Optional<Hotel> getHotelByid(Long id) { return hotelRepository.findById(id); }

    @Override
    public List<Hotel> getByNameContains(String description)
    { return hotelRepository.findByNameContains(description); }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }
}
