package com.amiaka.Reposiroty;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amiaka.Models.ApplicationUser;

public interface UserRepo extends JpaRepository<ApplicationUser, Long> {

	Optional<ApplicationUser> findByEmail(String email);

	Optional<ApplicationUser> findByRole(String string);

}
