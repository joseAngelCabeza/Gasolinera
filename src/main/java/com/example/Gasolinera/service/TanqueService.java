package com.example.Gasolinera.service;

import com.example.Gasolinera.model.Tanque;

import java.util.List;
import java.util.Optional;

public interface TanqueService {
    List<Tanque> findAll();
    Optional<Tanque> findById(Integer id);
    Tanque save(Tanque tanque);
    void deleteById(Integer id);
    List<Tanque> findByProductoIdProducto(Integer idProducto);
    List<Tanque> findTanquesBajoNivel(int porcentajeMinimo);
}
