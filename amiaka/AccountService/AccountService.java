package com.amiaka.AccountService;

import com.amiaka.FoodDto.FoodDto;

public interface AccountService {

	void DepositeAmount(long id);
	
	double ShowBalance(String name);
	
	void MakeOrder(FoodDto foodDto);
	
}
