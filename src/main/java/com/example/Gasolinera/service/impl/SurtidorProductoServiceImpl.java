package com.example.Gasolinera.service.impl;

import com.example.Gasolinera.model.SurtidorProducto;
import com.example.Gasolinera.repository.ISurtidorProductoRepository;
import com.example.Gasolinera.service.SurtidorProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurtidorProductoServiceImpl implements SurtidorProductoService {

    private final ISurtidorProductoRepository surtidorProductoRepository;

    @Autowired
    public SurtidorProductoServiceImpl(ISurtidorProductoRepository surtidorProductoRepository) {
        this.surtidorProductoRepository = surtidorProductoRepository;
    }

    @Override
    public List<SurtidorProducto> findAll() {
        return surtidorProductoRepository.findAll();
    }

    @Override
    public Optional<SurtidorProducto> findById(Long id) {
        return surtidorProductoRepository.findById(id);
    }

    @Override
    public SurtidorProducto save(SurtidorProducto surtidorProducto) {
        return surtidorProductoRepository.save(surtidorProducto);
    }

    @Override
    public void deleteById(Long id) {
        surtidorProductoRepository.deleteById(id);
    }

    @Override
    public List<SurtidorProducto> findBySurtidorIdSurtidor(Integer idSurtidor) {
        return surtidorProductoRepository.findBySurtidorIdSurtidor(idSurtidor);
    }

    @Override
    public List<SurtidorProducto> findByProductoIdProducto(Integer idProducto) {
        return surtidorProductoRepository.findByProductoIdProducto(idProducto);
    }
}

