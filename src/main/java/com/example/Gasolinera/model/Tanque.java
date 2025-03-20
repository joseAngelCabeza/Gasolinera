package com.example.Gasolinera.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tanque")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tanque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tanque")
    private Integer idTanque;

    @Column(nullable = false)
    private String codigo;

    @Column(name = "capacidad_maxima", precision = 10, scale = 2)
    private BigDecimal capacidadMaxima;

    @Column(name = "nivel_actual", precision = 10, scale = 2)
    private BigDecimal nivelActual;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    public Integer getIdTanque() {
        return idTanque;
    }

    public void setIdTanque(Integer idTanque) {
        this.idTanque = idTanque;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(BigDecimal capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public BigDecimal getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(BigDecimal nivelActual) {
        this.nivelActual = nivelActual;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
