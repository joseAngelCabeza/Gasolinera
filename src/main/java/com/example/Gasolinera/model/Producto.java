package com.example.Gasolinera.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    private String tipo;

    @ManyToMany(mappedBy = "productos")
    private Set<Surtidor> surtidores = new HashSet<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<Precio> precios = new HashSet<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<Suministro> suministros = new HashSet<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<Tanque> tanques = new HashSet<>();

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Surtidor> getSurtidores() {
        return surtidores;
    }

    public void setSurtidores(Set<Surtidor> surtidores) {
        this.surtidores = surtidores;
    }

    public Set<Precio> getPrecios() {
        return precios;
    }

    public void setPrecios(Set<Precio> precios) {
        this.precios = precios;
    }

    public Set<Suministro> getSuministros() {
        return suministros;
    }

    public void setSuministros(Set<Suministro> suministros) {
        this.suministros = suministros;
    }

    public Set<Tanque> getTanques() {
        return tanques;
    }

    public void setTanques(Set<Tanque> tanques) {
        this.tanques = tanques;
    }
}

