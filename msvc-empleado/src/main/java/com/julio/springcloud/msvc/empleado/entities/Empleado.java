package com.julio.springcloud.msvc.empleado.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nombre es requerido")
    private String name;

    @NotBlank(message = "apellido es requerido")
    private String lastName;

    @NotBlank(message = "contraseña requerida")
    private String password;

    // debe ser opcional
    // private String role;

    @Email(message = "El email es requerido")
    @NotBlank(message = "El email es requerido")
    private String email;

    @NotBlank(message = "El DNI es requerido")
    private String dni;

    @NotBlank(message = "El telefono es requerido")
    private String telefono;
}
