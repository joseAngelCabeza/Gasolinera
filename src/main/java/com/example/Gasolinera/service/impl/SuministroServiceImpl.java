package com.example.Gasolinera.service.impl;

import com.example.Gasolinera.model.Suministro;
import com.example.Gasolinera.repository.ISuministroRepository;
import com.example.Gasolinera.service.SuministroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SuministroServiceImpl implements SuministroService {

    private final ISuministroRepository suministroRepository;

    @Autowired
    public SuministroServiceImpl(ISuministroRepository suministroRepository) {
        this.suministroRepository = suministroRepository;
    }

    @Override
    public List<Suministro> findAll() {
        return suministroRepository.findAll();
    }

    @Override
    public Optional<Suministro> findById(Integer id) {
        return suministroRepository.findById(id);
    }

    @Override
    public Suministro save(Suministro suministro) {
        return suministroRepository.save(suministro);
    }

    @Override
    public void deleteById(Integer id) {
        suministroRepository.deleteById(id);
    }

    @Override
    public List<Suministro> findBySurtidorIdSurtidor(Integer idSurtidor) {
        return suministroRepository.findBySurtidorIdSurtidor(idSurtidor);
    }

    @Override
    public List<Suministro> findByProductoIdProducto(Integer idProducto) {
        return suministroRepository.findByProductoIdProducto(idProducto);
    }

    @Override
    public List<Suministro> findByFechaHoraBetween(LocalDateTime desde, LocalDateTime hasta) {
        return suministroRepository.findByFechaHoraBetween(desde, hasta);
    }
}
