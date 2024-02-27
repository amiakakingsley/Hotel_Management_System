package com.amiaka.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String room_name;
	private String username;
	private String time;
	private double price = 0.0;
	
	public Room() {}
	public Room(String room_name, String username,  double price) {
		super();
		this.room_name = room_name;
		this.username = username;
		
		this.price = price;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", room_name=" + room_name + ", username=" + username + ", time=" + time + ", price="
				+ price + "]";
	}
	
	
	
	
	
	
	
}
