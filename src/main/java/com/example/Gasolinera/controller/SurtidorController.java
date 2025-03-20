package com.example.Gasolinera.controller;

import com.example.Gasolinera.model.Surtidor;
import com.example.Gasolinera.service.SurtidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surtidores")
public class SurtidorController {

    private final SurtidorService surtidorService;

    @Autowired
    public SurtidorController(SurtidorService surtidorService) {
        this.surtidorService = surtidorService;
    }

    @GetMapping
    public ResponseEntity<List<Surtidor>> getAllSurtidores() {
        List<Surtidor> surtidores = surtidorService.findAll();
        return new ResponseEntity<>(surtidores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Surtidor> getSurtidorById(@PathVariable("id") Integer id) {
        return surtidorService.findById(id)
                .map(surtidor -> new ResponseEntity<>(surtidor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/crear")
    public ResponseEntity<Surtidor> createSurtidor(@RequestBody Surtidor surtidor) {
        Surtidor newSurtidor = surtidorService.save(surtidor);
        return new ResponseEntity<>(newSurtidor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Surtidor> updateSurtidor(@PathVariable("id") Integer id, @RequestBody Surtidor surtidor) {
        return surtidorService.findById(id)
                .map(existingSurtidor -> {
                    surtidor.setIdSurtidor(id);
                    return new ResponseEntity<>(surtidorService.save(surtidor), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSurtidor(@PathVariable("id") Integer id) {
        try {
            surtidorService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/activos")
    public ResponseEntity<List<Surtidor>> getSurtidoresActivos() {
        List<Surtidor> surtidoresActivos = surtidorService.findByActivoTrue();
        return new ResponseEntity<>(surtidoresActivos, HttpStatus.OK);
    }
}


