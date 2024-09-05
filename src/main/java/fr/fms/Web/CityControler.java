package fr.fms.Web;

import fr.fms.service.HotelServiceImpl;
import fr.fms.entity.City;
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
public class CityControler {
    @Autowired
    HotelServiceImpl hotelService;

    @GetMapping("/citys")
    public List<City> allHotels() {
        List<City> lT = hotelService.getCitys();
        return hotelService.getCitys();
    }

    @GetMapping("/cityid/{id}")
    public Optional<City> getCatById(@PathVariable("id") Long id) {
        return hotelService.findCityById(id);
    }

    @PostMapping("/city")
    public ResponseEntity<City> saveTraining(@RequestBody City city) {
        City city1 = hotelService.saveCity(city);
        if (Objects.isNull(city1)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(city1.getId())
                .toUri();
        return ResponseEntity.created(location).body(city1);
    }
}
