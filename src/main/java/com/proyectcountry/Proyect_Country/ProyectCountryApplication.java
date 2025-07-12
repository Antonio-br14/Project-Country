package com.proyectcountry.Proyect_Country;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyectcountry.Proyect_Country.principal.Principal;
@SpringBootApplication
public class ProyectCountryApplication implements CommandLineRunner{


	public static void main(String[] args) {
		SpringApplication.run(ProyectCountryApplication.class, args);
		//Principal principal = new Principal();
		//principal.mostrarMenu();
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.mostrarMenu();
	}

	

	
}
