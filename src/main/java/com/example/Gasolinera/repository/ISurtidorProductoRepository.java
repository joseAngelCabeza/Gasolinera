package com.example.Gasolinera.repository;

import com.example.Gasolinera.model.SurtidorProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ISurtidorProductoRepository extends JpaRepository<SurtidorProducto, Long> {

    /**
     * Encuentra relaciones por el ID del surtidor
     * @param idSurtidor ID del surtidor
     * @return Lista de relaciones para el surtidor especificado
     */
    List<SurtidorProducto> findBySurtidorIdSurtidor(Integer idSurtidor);

    /**
     * Encuentra relaciones por el ID del producto
     * @param idProducto ID del producto
     * @return Lista de relaciones para el producto especificado
     */
    List<SurtidorProducto> findByProductoIdProducto(Integer idProducto);

    /**
     * Verifica si existe una relación entre un surtidor y un producto
     * @param idSurtidor ID del surtidor
     * @param idProducto ID del producto
     * @return true si existe la relación, false en caso contrario
     */
    boolean existsBySurtidorIdSurtidorAndProductoIdProducto(Integer idSurtidor, Integer idProducto);

    /**
     * Elimina una relación entre un surtidor y un producto
     * @param idSurtidor ID del surtidor
     * @param idProducto ID del producto
     */
    void deleteBySurtidorIdSurtidorAndProductoIdProducto(Integer idSurtidor, Integer idProducto);
}


