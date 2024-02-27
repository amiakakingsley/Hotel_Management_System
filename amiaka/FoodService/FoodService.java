package com.amiaka.FoodService;

import java.util.List;

import com.amiaka.FoodDto.FoodDto;
import com.amiaka.Models.Food;
import com.amiaka.Models.Room;

public interface FoodService {
  void SaveFood(FoodDto foodDto);
  
  List<Food> getAllFood();
  
  List<Food> findByName(String name);
  
  void SaveRoom(Room room);
  
}
