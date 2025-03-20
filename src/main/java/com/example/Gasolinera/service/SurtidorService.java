package com.example.Gasolinera.service;

import com.example.Gasolinera.model.Surtidor;

import java.util.List;
import java.util.Optional;

public interface SurtidorService {
    List<Surtidor> findAll();
    Optional<Surtidor> findById(Integer id);
    Surtidor save(Surtidor surtidor);
    void deleteById(Integer id);
    List<Surtidor> findByActivoTrue();
}
