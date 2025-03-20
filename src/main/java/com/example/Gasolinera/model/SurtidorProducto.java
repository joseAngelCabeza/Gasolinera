package com.example.Gasolinera.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Esta clase representa la tabla de unión entre Surtidor y Producto.
 * Nota: En JPA, esta tabla de unión normalmente se maneja automáticamente con @ManyToMany,
 * pero si necesitas acceder directamente a esta entidad, puedes usar esta clase.
 */
@Entity
@Table(name = "surtidor_producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SurtidorProducto implements Serializable {

    @EmbeddedId
    private SurtidorProductoId id;

    @ManyToOne
    @MapsId("idSurtidor")
    @JoinColumn(name = "id_surtidor")
    private Surtidor surtidor;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SurtidorProductoId implements Serializable {

        @Column(name = "id_surtidor")
        private Integer idSurtidor;

        @Column(name = "id_producto")
        private Integer idProducto;
    }

    public SurtidorProductoId getId() {
        return id;
    }

    public void setId(SurtidorProductoId id) {
        this.id = id;
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
}
