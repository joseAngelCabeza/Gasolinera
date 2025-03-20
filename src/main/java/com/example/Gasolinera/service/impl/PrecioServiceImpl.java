package com.example.Gasolinera.service.impl;

import com.example.Gasolinera.model.Precio;
import com.example.Gasolinera.repository.IPrecioRepository;
import com.example.Gasolinera.service.PrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PrecioServiceImpl implements PrecioService {

    private final IPrecioRepository precioRepository;

    @Autowired
    public PrecioServiceImpl(IPrecioRepository precioRepository) {
        this.precioRepository = precioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Precio> findAll() {
        return precioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Precio> findById(Integer id) {
        return precioRepository.findById(id);
    }

    @Override
    public Precio save(Precio precio) {
        return precioRepository.save(precio);
    }

    @Override
    public void deleteById(Integer id) {
        precioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Precio> findByProductoIdProducto(Integer idProducto) {
        return precioRepository.findByProductoIdProducto(idProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Precio> findPreciosVigentes(LocalDate fecha) {
        return precioRepository.findPreciosVigentes(fecha);
    }
}
