package com.amiaka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.amiaka.Models.Account;
import com.amiaka.Models.ApplicationUser;
import com.amiaka.Reposiroty.UserRepo;

@SpringBootApplication
public class ZilnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZilnetApplication.class, args);
	}
	
	@Bean 
	CommandLineRunner arg(PasswordEncoder passwordEncoder, UserRepo userRepo) {
		return agrs->{
			if(userRepo.findByRole("ROLE_ADMIN").isPresent()) return;
			  
			ApplicationUser user = new ApplicationUser();
			user.setFirstname("Amiaka");
			user.setLastname("Kingsley");
			user.setEmail("kingsleyamiaka@gmail.com");
			user.setPassword(passwordEncoder.encode("123456678"));
			user.setRole("ROLE_ADMIN");
			
			Account admin = new Account();
			admin.setUsername(user.getEmail());
			admin.setUsers(user);
			
			user.setAccount(admin);
			
			userRepo.save(user);		
			
		};
	}

}
