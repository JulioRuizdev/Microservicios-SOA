package com.julio.springcloud.msvc.empleado.services;

import java.util.List;
import java.util.Optional;

import com.julio.springcloud.msvc.empleado.entities.Empleado;

public interface EmpleadoService {
    List<Empleado> findAll();

    Optional<Empleado> findById(Long id);

    Empleado save(Empleado empleado);

    void deleteById(Long id);

    Optional<Empleado> findByEmail(String email);
}
