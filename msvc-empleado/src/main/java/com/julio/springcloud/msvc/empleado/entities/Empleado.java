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

    public Empleado() {
    }

    public Empleado(String name, String lastName, String password, String email, String dni, String telefono) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
