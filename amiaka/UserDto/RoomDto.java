package com.amiaka.UserDto;

import java.time.LocalDate;

public class RoomDto {

	private String room_name;
	private double room_price = 0.0;
	private String username;
	private LocalDate localDate = LocalDate.now();

	public RoomDto() {}
	
	public RoomDto(String room_name, double room_price, String username) {
		super();
		this.room_name = room_name;
		this.room_price = room_price;
		this.username = username;
		this.localDate = LocalDate.now();
	}


	public String getRoom_name() {
		return room_name;
	}


	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public double getRoom_price() {
		return room_price;
	}

	public void setRoom_price(double room_price) {
		this.room_price = room_price;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	@Override
	public String toString() {
		return "RoomDto [room_name=" + room_name + ", room_price=" + room_price + ", username=" + username
				+ ", localDate=" + localDate + "]";
	}


	
	
}
