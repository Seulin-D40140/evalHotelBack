package fr.fms;

import fr.fms.Dao.*;
import fr.fms.Service.AccountServiceImpl;
import fr.fms.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Evaluation3HotelApplication implements CommandLineRunner {

	@Autowired
	CityRepository cityRepository;

	@Autowired
	HotelRepository hotelRepository;

	@Autowired
	AccountServiceImpl accountService;

	public static void main(String[] args) {
		SpringApplication.run(Evaluation3HotelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		generateCityandHotel();
		generateGerantandManager();
	}

	private void generateCityandHotel()
	{
		City Lyon = cityRepository.save(new City(null , "lyon" , "69000" , null));
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


	private void generateGerantandManager()
	{
		accountService.saveUser(new appUser(null , "nel" , "1234" , new ArrayList<>()));
		accountService.saveUser(new appUser(null , "angel" , "1234" ,new ArrayList<>()));
		accountService.saveUser(new appUser(null , "isha" , "1234" , new ArrayList<>()));
		accountService.saveUser(new appUser(null , "bubba" , "1234", new ArrayList<>()));

		accountService.saveRole(new appRole(null , "ADMIN"));
		accountService.saveRole(new appRole(null , "USER"));
		accountService.saveRole(new appRole(null , "GERANT"));
		
		accountService.addRoleToUser("isha", "USER");
		accountService.addRoleToUser("nel", "ADMIN");
		accountService.addRoleToUser("angel", "GERANT");
		accountService.addRoleToUser("bubba", "GERANT");
	}

}
