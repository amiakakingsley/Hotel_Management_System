package com.amiaka.Reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amiaka.Models.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

	Room findByUsername(String name);

}
