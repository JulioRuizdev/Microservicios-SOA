package com.julio.springcloud.msvc.room.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Habitacion es requerida")
    private String roomType;

    @NotNull(message = " La capacidad es requerida")
    @Min(value = 1, message = "El valor minimo es 1")
    private Integer capacity;

    @NotNull(message = "El precio es requerido")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio minimo es 1")
    private Double price;

    public Room() {
    }

    public Room(Long id, @NotBlank(message = "Habitacion es requerida") String roomType,
            @NotNull(message = " La capacidad es requerida") @Min(value = 1, message = "El valor minimo es 1") Integer capacity,
            @NotNull(message = "El precio es requerido") @DecimalMin(value = "0.0", inclusive = false, message = "El precio minimo es 1") Double price) {
        this.id = id;
        this.roomType = roomType;
        this.capacity = capacity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}