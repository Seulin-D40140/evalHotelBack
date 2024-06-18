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
	GerantRepository gerantRepository;

	@Autowired
	ManagerRepository managerRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

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
		Hotel castle = hotelRepository.save(new Hotel(null , "castle" , "chateaux" , "12 av des tulipes" , 100 , 30 , "castle.jpg" , Lyon));
		Hotel house = hotelRepository.save(new Hotel(null , "house" , "house" , "3 av des roses" , 89 , 50 , "house.jpg" , Lyon));
		Hotel azul = hotelRepository.save(new Hotel(null , "azul" , "blue azur" , "124 av des camelia" , 90 , 10 , "azul.jpg" , Lyon));
		City Lille = cityRepository.save(new City(null , "lille" , "59000" , null));
		Hotel Roses = hotelRepository.save(new Hotel(null , "Roses" , "demeure charmante" , "12 av des poires" , 150 , 40 , "roses.jpg" , Lille));
		Hotel lyss = hotelRepository.save(new Hotel(null , "lyss" , "cuisine feux de bois" , "8 av des pommes" , 95 , 55 , "lyss.jpg" , Lille));
		Hotel rojo = hotelRepository.save(new Hotel(null , "rojo" , "fleur dans les champs" , "14 av des cerises" , 65 , 150 , "rojo.jpg" , Lille));
		City bayonne = cityRepository.save(new City(null , "bayonne" , "64000" , null));
		Hotel cerise = hotelRepository.save(new Hotel(null , "cerise" , "demeure charmante" , "12 av des poires" , 150 , 40 , null , bayonne));
		Hotel pomme = hotelRepository.save(new Hotel(null , "pomme" , "cuisine feux de bois" , "8 av des pommes" , 95 , 55 , null , bayonne));
		Hotel poire = hotelRepository.save(new Hotel(null , "poire" , "fleur dans les champs" , "14 av des cerises" , 65 , 150 , null , Lille));
		City paris = cityRepository.save(new City(null , "paris" , "95000" , null));
		Hotel bois = hotelRepository.save(new Hotel(null , "bois" , "demeure charmante" , "12 av des poires" , 150 , 40 , null , paris));
		Hotel foret = hotelRepository.save(new Hotel(null , "foret" , "cuisine feux de bois" , "8 av des pommes" , 95 , 55 , null , paris));
		Hotel montagne = hotelRepository.save(new Hotel(null , "montagne" , "fleur dans les champs" , "14 av des cerises" , 65 , 150 , null , paris));
		City bordeaux = cityRepository.save(new City(null , "bordeaux" , "33000" , null));
		Hotel tulipes = hotelRepository.save(new Hotel(null , "tulipes" , "demeure charmante" , "12 av des poires" , 150 , 40 , null , bordeaux));
		Hotel camelia = hotelRepository.save(new Hotel(null , "lyss" , "cuisine feux de bois" , "8 av des pommes" , 95 , 55 , null , bordeaux));
		Hotel sunflower = hotelRepository.save(new Hotel(null , "sunflower" , "fleur dans les champs" , "14 av des cerises" , 65 , 150 , null , bordeaux));
	}


	private void generateGerantandManager()
	{
		Manager Nel = managerRepository.save(new Manager(null , "nel" , "nel" , "1234" , new ArrayList<>()));
		Gerant Angel = gerantRepository.save(new Gerant(null , "angel" , "angel" , "1234" ,new ArrayList<>()));
		appUser Isha = userRepository.save(new appUser(null , "isha" , "isha" , "1234" , new ArrayList<>()));
		Gerant Bubba = gerantRepository.save(new Gerant(null , "bubba" , "bubba" , "1234", new ArrayList<>()));

		roleRepository.save(new Role(null , "ADMIN"));
		roleRepository.save(new Role(null , "USER"));
		roleRepository.save(new Role(null , "GERANT"));
		accountService.addRoleToUser("isha", "USER");
		accountService.addRoleToGerant("angel", "ADMIN");
		accountService.addRoleToManager("nel", "GERANT");
		accountService.addRoleToGerant("bubba", "GERANT");
	}

}
