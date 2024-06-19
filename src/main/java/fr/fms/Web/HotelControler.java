package fr.fms.Web;

import fr.fms.Service.HotelServiceImpl;
import fr.fms.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
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
        return hotelService.getHotels();
    }

    @GetMapping("/hotelByCity/{id}")
    public  List<Hotel> HotelByCity(@PathVariable("id") Long id)
    {
        return hotelService.getHotelByCity(id);
    }

    @GetMapping("/searchByKey/{key}")
    public List<Hotel> index( @PathVariable("key") String kw) {
        return hotelService.getByNameContains(kw);
    }

    @GetMapping("/hotelById/{id}")
    public Optional<Hotel> index(@PathVariable("id") Long id) {
        return hotelService.getHotelByid(id);
    }

    @PostMapping("/hotels")
    public ResponseEntity<Hotel> saveTraining(@RequestBody Hotel hotel){
        Hotel hotelo = hotelService.saveHotel(hotel);
        if(Objects.isNull(hotelo)){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(hotelo.getId())
                .toUri();
        return ResponseEntity.created(location).body(hotelo);
    }
}
