package com.example.Gasolinera.service.impl;

import com.example.Gasolinera.model.Producto;
import com.example.Gasolinera.repository.IProductoRepository;
import com.example.Gasolinera.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final IProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> findByTipo(String tipo) {
        return productoRepository.findByTipo(tipo);
    }
}
