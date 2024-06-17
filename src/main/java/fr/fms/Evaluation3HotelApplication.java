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
		Hotel castle = hotelRepository.save(new Hotel(null , "castle" , "chateaux" , "12 av des tulipes" , 100 , 30 , "castle.png" , Lyon));
		Hotel house = hotelRepository.save(new Hotel(null , "house" , "house" , "3 av des roses" , 89 , 50 , "house.png" , Lyon));
		Hotel azul = hotelRepository.save(new Hotel(null , "azul" , "blue azur" , "124 av des camelia" , 90 , 10 , "azul.png" , Lyon));
		City Lille = cityRepository.save(new City(null , "lille" , "59000" , null));
		Hotel oculus = hotelRepository.save(new Hotel(null , "oculus" , "demeure charmante" , "12 av des poires" , 150 , 40 , "oculus.png" , Lille));
		Hotel natsu = hotelRepository.save(new Hotel(null , "natsu" , "cuisine feux de bois" , "8 av des pommes" , 95 , 55 , "natsu.png" , Lille));
		Hotel trunks = hotelRepository.save(new Hotel(null , "trunks" , "fleur dans les champs" , "14 av des cerises" , 65 , 150 , "trunks.png" , Lille));
	}


	private void generateGerantandManager()
	{
		Manager isha = managerRepository.save(new Manager(null , "isha" , new ArrayList<>()));
		Gerant Angel = gerantRepository.save(new Gerant(null , "angel" , new ArrayList<>()));
		Gerant Nel = gerantRepository.save(new Gerant(null , "nel" , new ArrayList<>()));
		Gerant Bubba = gerantRepository.save(new Gerant(null , "bubba" , new ArrayList<>()));

		roleRepository.save(new Role(null , "ADMIN"));
		roleRepository.save(new Role(null , "USER"));
		roleRepository.save(new Role(null , "GERANT"));
		accountService.addRoleToManager("isha", "ADMIN");
		accountService.addRoleToGerant("angel", "GERANT");
		accountService.addRoleToGerant("nel", "GERANT");
		accountService.addRoleToGerant("bubba", "GERANT");
	}

}
