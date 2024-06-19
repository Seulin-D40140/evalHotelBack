package fr.fms.Web;

import fr.fms.Dao.CityRepository;
import fr.fms.Service.HotelServiceImpl;
import fr.fms.entity.City;
import fr.fms.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CityControler
{
    @Autowired
    HotelServiceImpl hotelService;

    @GetMapping("/citys")
    public List<City> allHotels(){
        List <City> lT = hotelService.getCitys();
        return hotelService.getCitys();
    }

    @GetMapping("/cityid/{id}")
    public Optional<City> getCatById(@PathVariable("id") Long id)
    {
        return hotelService.findCityById(id);
    }
}
