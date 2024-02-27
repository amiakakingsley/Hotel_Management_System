package com.amiaka.FoodService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amiaka.FoodDto.FoodDto;
import com.amiaka.Models.Food;
import com.amiaka.Models.Room;
import com.amiaka.Reposiroty.FoodRepository;
@Service
public class FoodServiceIMPL implements FoodService {

	private final FoodRepository foodRepo;
	
	public FoodServiceIMPL(FoodRepository foodRepo) {
		super();
		this.foodRepo = foodRepo;
	}


	@Override
	public void SaveFood(FoodDto foodDto) {
	    
		Food food = new Food();
		food.setAmount(foodDto.getAmount());
		food.setFood(foodDto.getFood());
		food.setName(foodDto.getName());
		
		foodRepo.save(food);
	} 


	@Override
	public List<Food> getAllFood() {
		return foodRepo.findAll();
		 
	}


	@Override
	public List<Food> findByName(String name) {
		// TODO Auto-generated method stub
		return foodRepo.findByName(name);
	}


	@Override
	public void SaveRoom(Room room) {
		// TODO Auto-generated method stub
		
	}
	
	

}
