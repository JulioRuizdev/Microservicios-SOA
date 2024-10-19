package com.julio.springcloud.msvc.room.controllers;

import org.apache.hc.client5.http.auth.KerberosConfig.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.julio.springcloud.msvc.room.entities.Room;
import com.julio.springcloud.msvc.room.services.RoomService;

import jakarta.validation.Valid;

import java.io.IOException;
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
    @PostMapping("/crear-con-foto")
    public ResponseEntity<?> saveWithPhotoRoom(@Valid Room room, BindingResult result,
            @RequestParam MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result);
        }

        if (!file.isEmpty()) {
            room.setFoto(file.getBytes());
        }
        Room roomDB = roomService.save(room);

        return ResponseEntity.status(HttpStatus.CREATED).body(roomDB);
    }

    @PutMapping("/editar-con-foto/{id}")
    public ResponseEntity<?> editWithPhotoRoom(@Valid Room room, BindingResult result,
            @RequestParam MultipartFile file) throws IOException {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result);
        }

        Optional<Room> o = roomService.findById(room.getId());

        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Room roomDB = o.get();
        roomDB.setRoomType(room.getRoomType());
        roomDB.setCapacity(room.getCapacity());
        roomDB.setDescription(room.getDescription());
        roomDB.setPrice(room.getPrice());
        roomDB.setStatus(room.isStatus());

        if (!file.isEmpty()) {
            roomDB.setFoto(file.getBytes());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(roomService.save(roomDB));
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
