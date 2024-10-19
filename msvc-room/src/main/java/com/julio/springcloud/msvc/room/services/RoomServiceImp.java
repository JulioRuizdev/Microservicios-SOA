package com.julio.springcloud.msvc.room.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.springcloud.msvc.room.entities.Room;
import com.julio.springcloud.msvc.room.repositories.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImp implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> findAll() {
        return (List<Room>) roomRepository.findAll();
    }

    @Override
    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<Room> findByRoomType(String roomType) {
        return roomRepository.findByRoomType(roomType);
    }
}
