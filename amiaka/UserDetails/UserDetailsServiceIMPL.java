package com.amiaka.UserDetails;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amiaka.Reposiroty.UserRepo;

@Service
public class UserDetailsServiceIMPL implements UserDetailsService {

	private final UserRepo userRepo;
	
	public UserDetailsServiceIMPL(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByEmail(username)
		.map(UserDetailsIMPL::new)
		.orElseThrow(() -> new UsernameNotFoundException("user 404"));
	}

  
   
}
