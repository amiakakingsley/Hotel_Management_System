package com.amiaka.Reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amiaka.Models.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {

	Account findByUsername(String name);
   
}
