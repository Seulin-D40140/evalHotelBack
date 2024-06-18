package fr.fms.Web;

import fr.fms.Service.HotelServiceImpl;
import fr.fms.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/hotelByCity/{id}")
    public  List<Hotel> HotelByCity(@PathVariable("id") Long id)
    {
        return hotelService.getHotelByCity(id);
    }

    @GetMapping("/searchByKey/{key}")
    public List<Hotel> index( @PathVariable("key") String kw) {
        List<Hotel> hotel = hotelService.getByNameContains(kw);
        return hotelService.getByNameContains(kw);
    }

    @GetMapping("/hotelById/{id}")
    public Optional<Hotel> index(@PathVariable("id") Long id) {
        Optional<Hotel> hotel = hotelService.getHotelByid(id);
        return hotelService.getHotelByid(id);
    }
}
