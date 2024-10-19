package com.julio.springcloud.msvc.empleado.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.julio.springcloud.msvc.empleado.entities.Empleado;
import com.julio.springcloud.msvc.empleado.services.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empService;

    @GetMapping
    public List<Empleado> getAllUsers() {
        return empService.findAll();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getClientById(@PathVariable Long id) {
        Optional<Empleado> empleado = empService.findById(id);
        return empleado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear o actualizar un usuario
    @PostMapping("/crear")
    public Empleado saveClient(@RequestBody Empleado empleado) {
        return empService.save(empleado);
    }

    // Eliminar usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        empService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar usuario por email
    @GetMapping("/email")
    public ResponseEntity<Empleado> getClientByEmail(@RequestParam String email) {
        Optional<Empleado> empleado = empService.findByEmail(email);
        return empleado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/test")
    public String test() {
        return "El controlador está funcionando";
    }
}
