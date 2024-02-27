package com.amiaka.RoomService;

import com.amiaka.Models.Room;
import com.amiaka.UserDto.RoomDto;

public interface RoomService {
  void SaveRoom(RoomDto roomDto);
  
  Room FindByUsername(String name);
  
}
