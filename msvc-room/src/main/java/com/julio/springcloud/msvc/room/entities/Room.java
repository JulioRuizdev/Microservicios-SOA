package com.julio.springcloud.msvc.room.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

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

    @NotBlank(message = "La descripcion es requerida")
    private String description;

    @NotNull(message = "El estado es requerido")
    private boolean status;

    @NotNull(message = "El precio es requerido")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio minimo es 1")
    private Double price;

    @Lob
    @JsonIgnore
    private byte[] foto;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

    public Integer getFotoHashCode() {
        return (this.foto != null) ? this.foto.hashCode() : null;
    }

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public Room(Long id, @NotBlank(message = "Habitacion es requerida") String roomType,
            @NotNull(message = " La capacidad es requerida") @Min(value = 1, message = "El valor minimo es 1") Integer capacity,
            @NotBlank(message = "La descripcion es requerida") String description,
            @NotNull(message = "El estado es requerido") boolean status,
            @NotNull(message = "El precio es requerido") @DecimalMin(value = "0.0", inclusive = false, message = "El precio minimo es 1") Double price,
            byte[] foto, Date createAt) {
        this.id = id;
        this.roomType = roomType;
        this.capacity = capacity;
        this.description = description;
        this.status = status;
        this.price = price;
        this.foto = foto;
        this.createAt = createAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

}