package com.amiaka.AccountService;

import org.springframework.stereotype.Service;

import com.amiaka.FoodDto.FoodDto;
import com.amiaka.FoodService.FoodService;
import com.amiaka.Models.Account;
import com.amiaka.Models.InitialDeposite;
import com.amiaka.Reposiroty.AccountRepo;
import com.amiaka.Reposiroty.InitialDepositeRepo;

@Service
public class AccountServiceIMPL implements AccountService{

	private final AccountRepo accountRepo;
	private final FoodService foodservice;
	private final InitialDepositeRepo initialRepo;
	
	public AccountServiceIMPL(AccountRepo accountRepo, 
			                        FoodService foodservice,
			                          InitialDepositeRepo initialRepo) {
		super();
		this.accountRepo = accountRepo;
		this.foodservice = foodservice;
		this.initialRepo = initialRepo;
	}

	@Override
	public void DepositeAmount(long id) {
		
		if(initialRepo.findById(id).isPresent()) {
		
		InitialDeposite initialDeposite = initialRepo.findById(id).orElseThrow(null);
		
		Account account = accountRepo.findByUsername(initialDeposite.getName());
	    
		double amount = account.getBalance();
		
		account.setBalance(initialDeposite.getAmount() + amount);
		
		accountRepo.save(account);	
	}
	}
	@Override
	public double ShowBalance(String name) {
		return accountRepo.findByUsername(name).getBalance();
	}

	
	@Override
	public void MakeOrder(FoodDto foodDto) {
		Account account = accountRepo.findByUsername(foodDto.getName());
		double amount = account.getBalance();
		    if(amount >= foodDto.getAmount()) {
		    	account.setBalance(amount -= foodDto.getAmount());
		    	foodservice.SaveFood(foodDto);
		    }
	   accountRepo.save(account);
	}

}
