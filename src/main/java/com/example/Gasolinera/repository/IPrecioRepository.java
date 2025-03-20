package com.example.Gasolinera.repository;

import com.example.Gasolinera.model.Precio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IPrecioRepository extends JpaRepository<Precio, Integer> {

    /**
     * Encuentra precios por el ID del producto
     * @param idProducto ID del producto
     * @return Lista de precios del producto especificado
     */
    List<Precio> findByProductoIdProducto(Integer idProducto);

    /**
     * Encuentra precios vigentes en una fecha específica
     * @param fecha Fecha para la que se buscan precios vigentes
     * @return Lista de precios vigentes en la fecha especificada
     */
    @Query("SELECT p FROM Precio p WHERE p.fechaInicio <= :fecha AND (p.fechaFin IS NULL OR p.fechaFin >= :fecha)")
    List<Precio> findPreciosVigentes(@Param("fecha") LocalDate fecha);

    /**
     * Encuentra el precio vigente para un producto en una fecha específica
     * @param idProducto ID del producto
     * @param fecha Fecha para la que se busca el precio vigente
     * @return Precio vigente del producto en la fecha especificada
     */
    @Query("SELECT p FROM Precio p WHERE p.producto.idProducto = :idProducto AND p.fechaInicio <= :fecha AND (p.fechaFin IS NULL OR p.fechaFin >= :fecha)")
    Optional<Precio> findPrecioVigenteByProducto(@Param("idProducto") Integer idProducto, @Param("fecha") LocalDate fecha);

    /**
     * Encuentra el último precio registrado para un producto
     * @param idProducto ID del producto
     * @return Último precio registrado para el producto
     */
    @Query("SELECT p FROM Precio p WHERE p.producto.idProducto = :idProducto ORDER BY p.fechaInicio DESC")
    List<Precio> findLastPrecioByProducto(@Param("idProducto") Integer idProducto);
}


