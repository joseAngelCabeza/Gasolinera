package com.example.Gasolinera.repository;

import com.example.Gasolinera.model.Surtidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ISurtidorRepository extends JpaRepository<Surtidor, Integer> {

    /**
     * Encuentra todos los surtidores que están activos
     * @return Lista de surtidores activos
     */
    List<Surtidor> findByActivoTrue();

    /**
     * Encuentra surtidores por su código
     * @param codigo El código del surtidor
     * @return El surtidor encontrado
     */
    Surtidor findByCodigo(String codigo);
}
