package com.amiaka.Reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amiaka.Models.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

	List<Food> findByName(String name);

}
