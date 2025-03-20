package com.example.Gasolinera.repository;

import com.example.Gasolinera.model.Tanque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ITanqueRepository extends JpaRepository<Tanque, Integer> {

    /**
     * Encuentra tanques por el ID del producto
     * @param idProducto ID del producto
     * @return Lista de tanques que almacenan el producto especificado
     */
    List<Tanque> findByProductoIdProducto(Integer idProducto);

    /**
     * Encuentra tanques por su código
     * @param codigo Código del tanque
     * @return Tanque encontrado
     */
    Tanque findByCodigo(String codigo);

    /**
     * Encuentra tanques cuyo nivel actual está por debajo de un porcentaje de su capacidad máxima
     * @param porcentajeMinimo Porcentaje mínimo de llenado
     * @return Lista de tanques con nivel bajo
     */
    @Query("SELECT t FROM Tanque t WHERE (t.nivelActual / t.capacidadMaxima) * 100 < :porcentajeMinimo")
    List<Tanque> findTanquesBajoNivel(@Param("porcentajeMinimo") int porcentajeMinimo);

    /**
     * Calcula el porcentaje de llenado de un tanque
     * @param idTanque ID del tanque
     * @return Porcentaje de llenado
     */
    @Query("SELECT (t.nivelActual / t.capacidadMaxima) * 100 FROM Tanque t WHERE t.idTanque = :idTanque")
    Double calcularPorcentajeLlenado(@Param("idTanque") Integer idTanque);
}

