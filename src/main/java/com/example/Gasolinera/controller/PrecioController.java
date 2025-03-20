package com.example.Gasolinera.controller;

import com.example.Gasolinera.model.Precio;
import com.example.Gasolinera.service.PrecioService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/precios")
public class PrecioController {

    private final PrecioService precioService;

    @Autowired
    public PrecioController(PrecioService precioService) {
        this.precioService = precioService;
    }

    @GetMapping
    public ResponseEntity<List<Precio>> getAllPrecios() {
        List<Precio> precios = precioService.findAll();
        return new ResponseEntity<>(precios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Precio> getPrecioById(@PathVariable("id") Integer id) {
        return precioService.findById(id)
                .map(precio -> new ResponseEntity<>(precio, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/crear")
    public ResponseEntity<Precio> createPrecio(@RequestBody Precio precio) {
        Precio newPrecio = precioService.save(precio);
        return new ResponseEntity<>(newPrecio, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Precio> updatePrecio(@PathVariable("id") Integer id, @RequestBody Precio precio) {
        return precioService.findById(id)
                .map(existingPrecio -> {
                    precio.setIdPrecio(id);
                    return new ResponseEntity<>(precioService.save(precio), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> deletePrecio(@PathVariable("id") Integer id) {
        try {
            precioService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<List<Precio>> getPreciosByProducto(@PathVariable("idProducto") Integer idProducto) {
        List<Precio> precios = precioService.findByProductoIdProducto(idProducto);
        return new ResponseEntity<>(precios, HttpStatus.OK);
    }

    @GetMapping("/vigentes")
    public ResponseEntity<List<Precio>> getPreciosVigentes() {
        LocalDate hoy = LocalDate.now();
        List<Precio> precios = precioService.findPreciosVigentes(hoy);
        return new ResponseEntity<>(precios, HttpStatus.OK);
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<Precio>> getPreciosByFecha(
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        List<Precio> precios = precioService.findPreciosVigentes(fecha);
        return new ResponseEntity<>(precios, HttpStatus.OK);
    }
}

