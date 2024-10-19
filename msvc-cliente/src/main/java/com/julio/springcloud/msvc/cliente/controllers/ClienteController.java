package com.julio.springcloud.msvc.cliente.controllers;

import com.julio.springcloud.msvc.cliente.entities.Cliente;
import com.julio.springcloud.msvc.cliente.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService cliService;

    @GetMapping
    public List<Cliente> getAllUsers() {
        return cliService.findAll();
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientById(@PathVariable Long id) {
        Optional<Cliente> cliente = cliService.findById(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear o actualizar un usuario
    @PostMapping
    public Cliente saveClient(@RequestBody Cliente cliente) {
        return cliService.save(cliente);
    }

    // Eliminar usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        cliService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar usuario por email
    @GetMapping("/email")
    public ResponseEntity<Cliente> getClientByEmail(@RequestParam String email) {
        Optional<Cliente> cliente = cliService.findByEmail(email);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
