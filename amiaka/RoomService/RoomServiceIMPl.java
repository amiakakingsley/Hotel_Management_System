package com.amiaka.RoomService;

import org.springframework.stereotype.Service;

import com.amiaka.Models.Account;
import com.amiaka.Models.Room;
import com.amiaka.Reposiroty.AccountRepo;
import com.amiaka.Reposiroty.RoomRepository;
import com.amiaka.UserDto.RoomDto;
@Service
public class RoomServiceIMPl implements RoomService{

	private final RoomRepository roomRepository;
	private final AccountRepo accountRepo;


	public RoomServiceIMPl(RoomRepository roomRepository, AccountRepo accountRepo) {
		super();
		this.roomRepository = roomRepository;
		this.accountRepo = accountRepo;
	}

	@Override
	public void SaveRoom(RoomDto roomDto) {
		Room room = new Room();
		
		room.setUsername(roomDto.getUsername());
		room.setPrice(roomDto.getRoom_price());
		room.setTime(roomDto.getLocalDate().toString());
		room.setRoom_name(roomDto.getRoom_name());
		
		Account account = accountRepo.findByUsername(roomDto.getUsername());
		double amount = account.getBalance();
		if(amount >= roomDto.getRoom_price()) {
			
			account.setBalance(amount -= roomDto.getRoom_price());
			accountRepo.save(account);
			roomRepository.save(room);
		}
		
		
	}

	@Override
	public Room FindByUsername(String name) {
		return roomRepository.findByUsername(name); 
	}

}
