package com.balenii.groupi.cuddlepaw_cottage;

import com.balenii.groupi.cuddlepaw_cottage.Entities.Role;
import com.balenii.groupi.cuddlepaw_cottage.Repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CuddlepawCottageApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuddlepawCottageApplication.class, args);
	}


//	CommandLineRunner init(RoleRepository roleRepository) {
//
//		return args -> {
//
//			Role adminRole = roleRepository.findByRole("ADMIN");
//			if (adminRole == null) {
//				Role newAdminRole = new Role();
//				newAdminRole.setRole("ADMIN");
//				roleRepository.save(newAdminRole);
//			}
//
//			Role userRole = roleRepository.findByRole("USER");
//			if (userRole == null) {
//				Role newUserRole = new Role();
//				newUserRole.setRole("USER");
//				roleRepository.save(newUserRole);
//			}
//		};
//
//	}


}
