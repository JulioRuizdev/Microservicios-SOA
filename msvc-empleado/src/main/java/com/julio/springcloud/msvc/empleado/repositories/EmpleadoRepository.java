package com.julio.springcloud.msvc.empleado.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.julio.springcloud.msvc.empleado.entities.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
    Optional<Empleado> findByEmail(String email);

}
