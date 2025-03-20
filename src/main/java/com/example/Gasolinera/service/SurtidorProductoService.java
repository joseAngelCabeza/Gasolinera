package com.example.Gasolinera.service;

import com.example.Gasolinera.model.SurtidorProducto;

import java.util.List;
import java.util.Optional;

public interface SurtidorProductoService {
    List<SurtidorProducto> findAll();
    Optional<SurtidorProducto> findById(Long id);
    SurtidorProducto save(SurtidorProducto surtidorProducto);
    void deleteById(Long id);
    List<SurtidorProducto> findBySurtidorIdSurtidor(Integer idSurtidor);
    List<SurtidorProducto> findByProductoIdProducto(Integer idProducto);
}

