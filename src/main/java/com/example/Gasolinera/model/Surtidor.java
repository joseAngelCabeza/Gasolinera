package com.example.Gasolinera.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "surtidor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Surtidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_surtidor")
    private Integer idSurtidor;

    @Column(nullable = false)
    private String codigo;

    @Column(name = "fecha_instalacion")
    private LocalDate fechaInstalacion;

    private boolean activo;

    @ManyToMany
    @JoinTable(
            name = "surtidor_producto",
            joinColumns = @JoinColumn(name = "id_surtidor"),
            inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private Set<Producto> productos = new HashSet<>();

    @OneToMany(mappedBy = "surtidor", cascade = CascadeType.ALL)
    private Set<Suministro> suministros = new HashSet<>();

    public Integer getIdSurtidor() {
        return idSurtidor;
    }

    public void setIdSurtidor(Integer idSurtidor) {
        this.idSurtidor = idSurtidor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(LocalDate fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public Set<Suministro> getSuministros() {
        return suministros;
    }

    public void setSuministros(Set<Suministro> suministros) {
        this.suministros = suministros;
    }
}


