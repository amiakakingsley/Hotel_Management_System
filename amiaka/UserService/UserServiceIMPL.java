package com.amiaka.UserService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amiaka.Models.Account;
import com.amiaka.Models.ApplicationUser;
import com.amiaka.Reposiroty.AccountRepo;
import com.amiaka.Reposiroty.UserRepo;
import com.amiaka.UserDto.ChangePasswordDto;
import com.amiaka.UserDto.UserDto;
@Service
public class UserServiceIMPL implements UserService  {

	
	private final UserRepo userRepo;
	private final PasswordEncoder passwordEncoder;
	private final AccountRepo accountRepo;
	
	public UserServiceIMPL(UserRepo userRepo, 
			PasswordEncoder passwordEncoder, 
			AccountRepo accountRepo) {
		super();
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
		this.accountRepo = accountRepo;
	}



	@Override
	public void SaveUser(UserDto userDto) {
		ApplicationUser user = new ApplicationUser();
		user.setFirstname(userDto.getFirstname());
		user.setLastname(userDto.getLastname());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setEmail(userDto.getEmail());
		user.setRole("ROLE_USER");
		
		String name = userDto.getFirstname() + " " + userDto.getLastname();
		Account account = accountRepo.findByUsername(name);
			if(account == null) {
				account = checkAcountDetails(userDto); 
			}
			
		user.setAccount(account);
		userRepo.save(user);
			
	}

	
       private Account checkAcountDetails(UserDto user) {
		Account account = new Account();
		account.setUsername(user.getEmail());
		account.setBalance(0.00);
		
		return accountRepo.save(account);
	    
	}



	@Override
	public UserDto findByEmail(String userDto) {
		ApplicationUser user = userRepo.findByEmail(userDto).orElse(null);
		UserDto user2 = new UserDto();
		user2.setEmail(user.getEmail());
		user2.setFirstname(user.getFirstname());
		user2.setLastname(user.getLastname());
		
		return user2;
	}



	@Override
	public void ChangePassword(ChangePasswordDto newPassword) {
		ApplicationUser user = userRepo.findByEmail(newPassword.getName()).orElse(null);
		user.setPassword(passwordEncoder.encode(newPassword.getPassword2()));
		
		userRepo.save(user);
	}


    

}
