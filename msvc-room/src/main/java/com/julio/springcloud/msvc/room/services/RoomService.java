package com.julio.springcloud.msvc.room.services;

import java.util.List;
import java.util.Optional;

import com.julio.springcloud.msvc.room.entities.Room;

public interface RoomService {
    // Obtener todas las habitaciones
    List<Room> findAll();

    // Obtener habitación por ID
    Optional<Room> findById(Long id);

    // Guardar o actualizar una habitación
    Room save(Room room);

    // Eliminar habitación por ID
    void deleteById(Long id);

    // Buscar habitaciones por tipo
    List<Room> findByRoomType(String roomType);
}