package com.amiaka.UserDto;

public class InitialFood {
   private String name;
   private long price;
   private String food_name;
   
   public InitialFood() {}
   
   

    public InitialFood(String name, long price, String food_name) {
	super();
	this.name = name;
	this.price = price;
	this.food_name = food_name;
     }



public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public long getPrice() {
	return price;
}

public void setPrice(long price) {
	this.price = price;
}

public String getFood_name() {
	return food_name;
}

public void setFood_name(String food_name) {
	this.food_name = food_name;
}
   
   
}
