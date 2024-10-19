package com.julio.springcloud.msvc.room.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.julio.springcloud.msvc.room.entities.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findByRoomType(String roomType);
}
