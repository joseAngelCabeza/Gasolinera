package com.example.Gasolinera.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "precio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Precio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_precio")
    private Integer idPrecio;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "precio_por_litro", precision = 10, scale = 3, nullable = false)
    private BigDecimal precioPorLitro;

    public Integer getIdPrecio() {
        return idPrecio;
    }

    public Producto getProducto() {
        return producto;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public BigDecimal getPrecioPorLitro() {
        return precioPorLitro;
    }

    public void setIdPrecio(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setPrecioPorLitro(BigDecimal precioPorLitro) {
        this.precioPorLitro = precioPorLitro;
    }
}