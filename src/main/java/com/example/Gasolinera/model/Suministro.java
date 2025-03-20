package com.example.Gasolinera.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "suministro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Suministro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suministro")
    private Integer idSuministro;

    @ManyToOne
    @JoinColumn(name = "id_surtidor", nullable = false)
    private Surtidor surtidor;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "volumen_litros", precision = 10, scale = 2)
    private BigDecimal volumenLitros;

    @Column(name = "importe_euros", precision = 10, scale = 2)
    private BigDecimal importeEuros;

    public Integer getIdSuministro() {
        return idSuministro;
    }

    public void setIdSuministro(Integer idSuministro) {
        this.idSuministro = idSuministro;
    }

    public Surtidor getSurtidor() {
        return surtidor;
    }

    public void setSurtidor(Surtidor surtidor) {
        this.surtidor = surtidor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public BigDecimal getVolumenLitros() {
        return volumenLitros;
    }

    public void setVolumenLitros(BigDecimal volumenLitros) {
        this.volumenLitros = volumenLitros;
    }

    public BigDecimal getImporteEuros() {
        return importeEuros;
    }

    public void setImporteEuros(BigDecimal importeEuros) {
        this.importeEuros = importeEuros;
    }
}

