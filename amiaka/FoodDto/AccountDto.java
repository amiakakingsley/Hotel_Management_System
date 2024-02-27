package com.amiaka.FoodDto;
public class AccountDto {

	private long id;
	private double amount;
	private String name;
	
	public AccountDto() {}
	
	public AccountDto(long id,double amount, String name) {
		this.id = id;
		this.amount = amount;
		this.name = name;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return "AccountDto [amount=" + amount + ", name=" + name + "]";
	}

	
	
	
}
