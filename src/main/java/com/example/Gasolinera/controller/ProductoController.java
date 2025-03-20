package com.example.Gasolinera.controller;

import com.example.Gasolinera.model.Producto;
import com.example.Gasolinera.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto newProducto = productoService.save(producto);
        return new ResponseEntity<>(newProducto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> productos = productoService.findAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable("id") Integer id) {
        return productoService.findById(id)
                .map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Producto>> getProductosByTipo(@PathVariable("tipo") String tipo) {
        List<Producto> productos = productoService.findByTipo(tipo);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable("id") Integer id, @RequestBody Producto producto) {
        return productoService.findById(id)
                .map(existingProducto -> {
                    producto.setIdProducto(id);
                    return new ResponseEntity<>(productoService.save(producto), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("id") Integer id) {
        try {
            productoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

