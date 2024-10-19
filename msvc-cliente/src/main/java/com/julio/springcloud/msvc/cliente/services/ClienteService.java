package com.julio.springcloud.msvc.cliente.services;

import com.julio.springcloud.msvc.cliente.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Cliente save(Cliente cliente);

    void deleteById(Long id);

    Optional<Cliente> findByEmail(String email);
}
