package com.example.Gasolinera.controller;

import com.example.Gasolinera.model.Tanque;
import com.example.Gasolinera.service.TanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/tanques")
public class TanqueController {

    private final TanqueService tanqueService;

    @Autowired
    public TanqueController(TanqueService tanqueService) {
        this.tanqueService = tanqueService;
    }

    @GetMapping
    public ResponseEntity<List<Tanque>> getAllTanques() {
        List<Tanque> tanques = tanqueService.findAll();
        return new ResponseEntity<>(tanques, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tanque> getTanqueById(@PathVariable("id") Integer id) {
        return tanqueService.findById(id)
                .map(tanque -> new ResponseEntity<>(tanque, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/crear")
    public ResponseEntity<Tanque> createTanque(@RequestBody Tanque tanque) {
        Tanque newTanque = tanqueService.save(tanque);
        return new ResponseEntity<>(newTanque, HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Tanque> updateTanque(@PathVariable("id") Integer id, @RequestBody Tanque tanque) {
        return tanqueService.findById(id)
                .map(existingTanque -> {
                    tanque.setIdTanque(id);
                    return new ResponseEntity<>(tanqueService.save(tanque), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> deleteTanque(@PathVariable("id") Integer id) {
        try {
            tanqueService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<List<Tanque>> getTanquesByProducto(@PathVariable("idProducto") Integer idProducto) {
        List<Tanque> tanques = tanqueService.findByProductoIdProducto(idProducto);
        return new ResponseEntity<>(tanques, HttpStatus.OK);
    }

    @PatchMapping("/{id}/nivel")
    public ResponseEntity<Tanque> actualizarNivelTanque(
            @PathVariable("id") Integer id,
            @RequestParam("nivel") BigDecimal nivelActual) {
        return tanqueService.findById(id)
                .map(tanque -> {
                    tanque.setNivelActual(nivelActual);
                    return new ResponseEntity<>(tanqueService.save(tanque), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/bajoNivel")
    public ResponseEntity<List<Tanque>> getTanquesBajoNivel(
            @RequestParam(value = "porcentaje", defaultValue = "20") int porcentajeMinimo) {
        List<Tanque> tanquesBajoNivel = tanqueService.findTanquesBajoNivel(porcentajeMinimo);
        return new ResponseEntity<>(tanquesBajoNivel, HttpStatus.OK);
    }
}
