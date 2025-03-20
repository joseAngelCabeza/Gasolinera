package com.example.Gasolinera.controller;

import com.example.Gasolinera.model.Suministro;
import com.example.Gasolinera.service.SuministroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/suministros")
public class SuministroController {

    private final SuministroService suministroService;

    @Autowired
    public SuministroController(SuministroService suministroService) {
        this.suministroService = suministroService;
    }

    @GetMapping("/traer")
    public ResponseEntity<List<Suministro>> getAllSuministros() {
        List<Suministro> suministros = suministroService.findAll();
        return new ResponseEntity<>(suministros, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<Suministro> getSuministroById(@PathVariable("id") Integer id) {
        return suministroService.findById(id)
                .map(suministro -> new ResponseEntity<>(suministro, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/crear")
    public ResponseEntity<Suministro> createSuministro(@RequestBody Suministro suministro) {
        Suministro newSuministro = suministroService.save(suministro);
        return new ResponseEntity<>(newSuministro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suministro> updateSuministro(@PathVariable("id") Integer id, @RequestBody Suministro suministro) {
        return suministroService.findById(id)
                .map(existingSuministro -> {
                    suministro.setIdSuministro(id);
                    return new ResponseEntity<>(suministroService.save(suministro), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HttpStatus> deleteSuministro(@PathVariable("id") Integer id) {
        try {
            // Lógica para eliminar el suministro por ID
            suministroService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/surtidor/{idSurtidor}")
    public ResponseEntity<List<Suministro>> getSuministrosBySurtidor(@PathVariable("idSurtidor") Integer idSurtidor) {
        List<Suministro> suministros = suministroService.findBySurtidorIdSurtidor(idSurtidor);
        return new ResponseEntity<>(suministros, HttpStatus.OK);
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<List<Suministro>> getSuministrosByProducto(@PathVariable("idProducto") Integer idProducto) {
        List<Suministro> suministros = suministroService.findByProductoIdProducto(idProducto);
        return new ResponseEntity<>(suministros, HttpStatus.OK);
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<Suministro>> getSuministrosByFechaRange(
            @RequestParam("desde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
            @RequestParam("hasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta) {
        List<Suministro> suministros = suministroService.findByFechaHoraBetween(desde, hasta);
        return new ResponseEntity<>(suministros, HttpStatus.OK);
    }
}