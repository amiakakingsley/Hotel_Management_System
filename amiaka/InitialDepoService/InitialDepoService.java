package com.amiaka.InitialDepoService;

import java.util.List;

import com.amiaka.FoodDto.AccountDto;
import com.amiaka.Models.InitialDeposite;

public interface InitialDepoService {

	void SaveIntialDepoSite(AccountDto accountDto);
	
	
	List<InitialDeposite> findAllInitailDeposite();
	
	List<InitialDeposite> findByDeositorsName(String name);
	
	InitialDeposite []  ReturnArraysDeposited();


	void DeleteIntialDeposite(Long id);
}
