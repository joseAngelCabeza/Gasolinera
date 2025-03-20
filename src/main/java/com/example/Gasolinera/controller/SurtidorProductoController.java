package com.example.Gasolinera.controller;

import com.example.Gasolinera.model.SurtidorProducto;
import com.example.Gasolinera.service.SurtidorProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surtidor-productos")
public class SurtidorProductoController {

    private final SurtidorProductoService surtidorProductoService;

    @Autowired
    public SurtidorProductoController(SurtidorProductoService surtidorProductoService) {
        this.surtidorProductoService = surtidorProductoService;
    }

    @GetMapping
    public ResponseEntity<List<SurtidorProducto>> getAllSurtidorProductos() {
        List<SurtidorProducto> surtidorProductos = surtidorProductoService.findAll();
        return new ResponseEntity<>(surtidorProductos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurtidorProducto> getSurtidorProductoById(@PathVariable("id") Long id) {
        return surtidorProductoService.findById(id)
                .map(surtidorProducto -> new ResponseEntity<>(surtidorProducto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/crear")
    public ResponseEntity<SurtidorProducto> createSurtidorProducto(@RequestBody SurtidorProducto surtidorProducto) {
        SurtidorProducto newSurtidorProducto = surtidorProductoService.save(surtidorProducto);
        return new ResponseEntity<>(newSurtidorProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurtidorProducto> updateSurtidorProducto(
            @PathVariable("id") Long id,
            @RequestBody SurtidorProducto surtidorProducto) {
        return surtidorProductoService.findById(id)
                .map(existingSurtidorProducto -> {
                    // Actualizar solo los campos necesarios
                    existingSurtidorProducto.setSurtidor(surtidorProducto.getSurtidor());
                    existingSurtidorProducto.setProducto(surtidorProducto.getProducto());
                    return new ResponseEntity<>(surtidorProductoService.save(existingSurtidorProducto), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSurtidorProducto(@PathVariable("id") Long id) {
        try {
            surtidorProductoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/surtidor/{idSurtidor}")
    public ResponseEntity<List<SurtidorProducto>> getSurtidorProductosBySurtidor(
            @PathVariable("idSurtidor") Integer idSurtidor) {
        List<SurtidorProducto> surtidorProductos = surtidorProductoService.findBySurtidorIdSurtidor(idSurtidor);
        return new ResponseEntity<>(surtidorProductos, HttpStatus.OK);
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<List<SurtidorProducto>> getSurtidorProductosByProducto(
            @PathVariable("idProducto") Integer idProducto) {
        List<SurtidorProducto> surtidorProductos = surtidorProductoService.findByProductoIdProducto(idProducto);
        return new ResponseEntity<>(surtidorProductos, HttpStatus.OK);
    }
}

