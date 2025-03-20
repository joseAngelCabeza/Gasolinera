package com.example.Gasolinera.repository;

import com.example.Gasolinera.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    /**
     * Encuentra productos por su tipo
     * @param tipo El tipo de producto
     * @return Lista de productos del tipo especificado
     */
    List<Producto> findByTipo(String tipo);

    /**
     * Encuentra productos por nombre que contenga la cadena especificada (case insensitive)
     * @param nombre Parte del nombre a buscar
     * @return Lista de productos que coinciden con el criterio
     */
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}

