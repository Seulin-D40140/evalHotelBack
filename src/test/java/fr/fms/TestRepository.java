package fr.fms;


import fr.fms.Dao.CityRepository;
import fr.fms.Dao.HotelRepository;
import fr.fms.Dao.UserRepository;
import fr.fms.Service.AccountServiceImpl;
import fr.fms.entity.City;
import fr.fms.entity.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestRepository
{
    @MockBean
    AccountServiceImpl accountService;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    UserRepository userRepository;

    City Lyon;

    @BeforeEach
    void bdd ()
    {
        Lyon = cityRepository.save(new City(null , "lyon" , "69000" , null));
        hotelRepository.save(new Hotel(null , "castle" , "chateaux" , "12 av des tulipes" , 100 , 30 , "castle.jpg" , Lyon));
        hotelRepository.save(new Hotel(null , "house" , "house" , "3 av des roses" , 89 , 50 , "house.jpg" , Lyon));
        hotelRepository.save(new Hotel(null , "azul" , "blue azur" , "124 av des camelia" , 90 , 10 , "azul.jpg" , Lyon));
        City Lille = cityRepository.save(new City(null , "lille" , "59000" , null));
        hotelRepository.save(new Hotel(null , "Roses" , "demeure charmante" , "12 av des poires" , 150 , 40 , "roses.jpg" , Lille));
        hotelRepository.save(new Hotel(null , "lyss" , "cuisine feux de bois" , "8 av des pommes" , 95 , 55 , "lyss.jpg" , Lille));
        hotelRepository.save(new Hotel(null , "rojo" , "fleur dans les champs" , "14 av des cerises" , 65 , 150 , "rojo.jpg" , Lille));
        City bayonne = cityRepository.save(new City(null , "bayonne" , "64000" , null));
        hotelRepository.save(new Hotel(null , "cerise" , "demeure charmante" , "12 av des poires" , 150 , 40 , null , bayonne));
        hotelRepository.save(new Hotel(null , "pomme" , "cuisine feux de bois" , "8 av des pommes" , 95 , 55 , null , bayonne));
        hotelRepository.save(new Hotel(null , "poire" , "fleur dans les champs" , "14 av des cerises" , 65 , 150 , null , Lille));
        City paris = cityRepository.save(new City(null , "paris" , "95000" , null));
        hotelRepository.save(new Hotel(null , "bois" , "demeure charmante" , "12 av des poires" , 150 , 40 , null , paris));
        hotelRepository.save(new Hotel(null , "foret" , "cuisine feux de bois" , "8 av des pommes" , 95 , 55 , null , paris));
        hotelRepository.save(new Hotel(null , "montagne" , "fleur dans les champs" , "14 av des cerises" , 65 , 150 , null , paris));
        City bordeaux = cityRepository.save(new City(null , "bordeaux" , "33000" , null));
        hotelRepository.save(new Hotel(null , "tulipes" , "demeure charmante" , "12 av des poires" , 150 , 40 , null , bordeaux));
        hotelRepository.save(new Hotel(null , "lyss" , "cuisine feux de bois" , "8 av des pommes" , 95 , 55 , null , bordeaux));
        hotelRepository.save(new Hotel(null , "sunflower" , "fleur dans les champs" , "14 av des cerises" , 65 , 150 , null , bordeaux));
    }

    @Test
    void TestGetAllHotels()
    {
        List<Hotel> trainingL = hotelRepository.findAll();
        assertEquals("castle" , trainingL.get(0).getName());
    }

    @Test
    void TestGetHotelByCity()
    {
        List<Hotel> trainingCat = hotelRepository.findByCityId(Lyon.getId());
        assertNotNull(trainingCat.size());
    }

    @Test
    void TestGetCity()
    {
        List<City> categories = cityRepository.findAll();
        assertNotNull(categories.size());
    }
}
