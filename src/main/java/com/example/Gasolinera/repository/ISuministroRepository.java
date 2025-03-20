package com.example.Gasolinera.repository;

import com.example.Gasolinera.model.Suministro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public interface ISuministroRepository extends JpaRepository<Suministro, Integer> {

    /**
     * Encuentra suministros por el ID del surtidor
     * @param idSurtidor ID del surtidor
     * @return Lista de suministros realizados por el surtidor especificado
     */
    List<Suministro> findBySurtidorIdSurtidor(Integer idSurtidor);

    /**
     * Encuentra suministros por el ID del producto
     * @param idProducto ID del producto
     * @return Lista de suministros del producto especificado
     */
    List<Suministro> findByProductoIdProducto(Integer idProducto);

    /**
     * Encuentra suministros realizados entre dos fechas
     * @param desde Fecha de inicio
     * @param hasta Fecha de fin
     * @return Lista de suministros en el rango de fechas
     */
    List<Suministro> findByFechaHoraBetween(LocalDateTime desde, LocalDateTime hasta);

    /**
     * Encuentra suministros con un importe mayor al especificado
     * @param importe Importe mínimo
     * @return Lista de suministros con importe mayor al especificado
     */
    List<Suministro> findByImporteEurosGreaterThan(BigDecimal importe);

    /**
     * Calcula el total de litros suministrados por un surtidor en un rango de fechas
     * @param idSurtidor ID del surtidor
     * @param desde Fecha de inicio
     * @param hasta Fecha de fin
     * @return Total de litros suministrados
     */
    @Query("SELECT SUM(s.volumenLitros) FROM Suministro s WHERE s.surtidor.idSurtidor = :idSurtidor AND s.fechaHora BETWEEN :desde AND :hasta")
    BigDecimal calcularTotalLitrosPorSurtidor(@Param("idSurtidor") Integer idSurtidor, @Param("desde") LocalDateTime desde, @Param("hasta") LocalDateTime hasta);

    /**
     * Calcula el total de euros facturados por un surtidor en un rango de fechas
     * @param idSurtidor ID del surtidor
     * @param desde Fecha de inicio
     * @param hasta Fecha de fin
     * @return Total de euros facturados
     */
    @Query("SELECT SUM(s.importeEuros) FROM Suministro s WHERE s.surtidor.idSurtidor = :idSurtidor AND s.fechaHora BETWEEN :desde AND :hasta")
    BigDecimal calcularTotalEurosPorSurtidor(@Param("idSurtidor") Integer idSurtidor, @Param("desde") LocalDateTime desde, @Param("hasta") LocalDateTime hasta);
}
