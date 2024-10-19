package com.julio.springcloud.msvc.room.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.julio.springcloud.msvc.room.entities.Room;
import com.julio.springcloud.msvc.room.services.RoomService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // Obtener todas las habitaciones
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.findAll();
    }

    // Obtener una habitación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Optional<Room> room = roomService.findById(id);
        return room.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear o actualizar una habitación
    @PostMapping
    public Room saveRoom(@RequestBody Room room) {
        return roomService.save(room);
    }

    // Eliminar una habitación por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar habitaciones por tipo de habitación
    @GetMapping("/type")
    public List<Room> getRoomsByType(@RequestParam String roomType) {
        return roomService.findByRoomType(roomType);
    }
}
