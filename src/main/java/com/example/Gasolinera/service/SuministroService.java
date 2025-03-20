package com.example.Gasolinera.service;

import com.example.Gasolinera.model.Suministro;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SuministroService {
    List<Suministro> findAll();
    Optional<Suministro> findById(Integer id);
    Suministro save(Suministro suministro);
    void deleteById(Integer id);
    List<Suministro> findBySurtidorIdSurtidor(Integer idSurtidor);
    List<Suministro> findByProductoIdProducto(Integer idProducto);
    List<Suministro> findByFechaHoraBetween(LocalDateTime desde, LocalDateTime hasta);
}


