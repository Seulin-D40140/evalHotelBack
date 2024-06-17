package fr.fms.Web;

import fr.fms.Dao.CityRepository;
import fr.fms.Service.HotelServiceImpl;
import fr.fms.entity.City;
import fr.fms.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
