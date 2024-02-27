package com.amiaka;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.amiaka.RoomService.RoomService;
import com.amiaka.UserDto.InitialFood;
import com.amiaka.UserDto.RoomDto;

@Controller
public class DashBoardController {
		
	private final RoomService roomService;

	public DashBoardController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}

	@GetMapping("/home/food")
	public String Food1() {
		return "food";
	}
	
	@GetMapping("/home/rooms")
	public String room() {
		return "room";
	}
	
	@PostMapping("/user/order")
	public String ComfirmOrder(InitialFood initialFood, Model model) {
		model.addAttribute("food", initialFood);
		return "comfirmOrderPage";
	}
	
	@PostMapping("/user/order/Room")
	public String BookRoom(Model model, RoomDto roomDto) {
		model.addAttribute("room", roomDto);	
		return "ConfirmRoom";
	}
	
	@PostMapping("/user/confirmRoom")
	public String ComfirmRoom(RoomDto roomDto, Principal principal) {
		roomDto.setUsername(principal.getName());
		
		
		roomService.SaveRoom(roomDto);
		return "home.html";
		
	}
	
	
}
