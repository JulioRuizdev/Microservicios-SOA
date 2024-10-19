package com.julio.springcloud.msvc.empleado.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.springcloud.msvc.empleado.entities.Empleado;
import com.julio.springcloud.msvc.empleado.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    @Override
    public List<Empleado> findAll() {
        return (List<Empleado>) repository.findAll();
    }

    @Override
    public Optional<Empleado> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Empleado save(Empleado cliente) {
        return repository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Empleado> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
