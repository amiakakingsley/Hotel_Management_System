package com.amiaka.InitialDepoService;

import java.util.List;
import org.springframework.stereotype.Service;

import com.amiaka.FoodDto.AccountDto;
import com.amiaka.Models.InitialDeposite;
import com.amiaka.Reposiroty.InitialDepositeRepo;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class InitialDepoServiceIMPL implements InitialDepoService {

	private final InitialDepositeRepo initialRepo;
	private final InitialDepoMapper initialMapper;
	
	public InitialDepoServiceIMPL(InitialDepositeRepo initialRepo, InitialDepoMapper initialMapper) {
		super();
		this.initialRepo = initialRepo;
		this.initialMapper = initialMapper;
	}

	@Override
	public void SaveIntialDepoSite(AccountDto accountDto) {
		InitialDeposite account = new InitialDeposite();
		account.setAmount(accountDto.getAmount());
		account.setName(accountDto.getName());
		
		initialRepo.save(account);
	}

	@Override
	public List<InitialDeposite> findAllInitailDeposite() {
		// TODO Auto-generated method stub
		return initialRepo.findAll();
	}

	@Override
	public List<InitialDeposite> findByDeositorsName(String name) {
		// TODO Auto-generated method stub
		return initialRepo.findByName(name);
	}

	@Override
	public void DeleteIntialDeposite(Long id ) {
		initialRepo.deleteById(id);
	}

	public InitialDeposite[] ReturnArraysDeposited() {
		InitialDeposite[] deposite = initialMapper.getInitialDeposites();
		return deposite;
	}


}
