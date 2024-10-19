package com.julio.springcloud.msvc.cliente.repositories;

import com.julio.springcloud.msvc.cliente.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    Optional<Cliente> findByEmail(String email);
}