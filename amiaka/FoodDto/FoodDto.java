package com.amiaka.FoodDto;

public class FoodDto {

	private String food;
	private double amount;
	private String name;
	
	public FoodDto() {}


	public FoodDto(String food, double amount, String name) {
		super();
		this.food = food;
		this.amount = amount;
		this.name = name;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "FoodDto [food=" + food + ", amount=" + amount + ", name=" + name + "]";
	}
	
	
}
