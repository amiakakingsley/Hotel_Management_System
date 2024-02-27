package com.amiaka.Reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amiaka.Models.InitialDeposite;

public interface InitialDepositeRepo extends JpaRepository<InitialDeposite, Long> {

	List<InitialDeposite> findByName(String name);


}
