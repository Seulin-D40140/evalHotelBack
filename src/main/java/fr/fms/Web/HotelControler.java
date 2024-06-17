package fr.fms.Web;

import fr.fms.Service.HotelServiceImpl;
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
public class HotelControler
{
    @Autowired
    HotelServiceImpl hotelService;

    @GetMapping("/hotels")
    public List<Hotel> allHotels(){
        List <Hotel> lT = hotelService.getHotels();
        return hotelService.getHotels();
    }
}
