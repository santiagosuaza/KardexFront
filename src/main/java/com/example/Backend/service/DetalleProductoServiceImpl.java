package com.example.Backend.service;

import com.example.Backend.model.DetalleProducto;
import com.example.Backend.repository.DetalleProductosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleProductoServiceImpl implements IDetalleProductoService {

    private final DetalleProductosRepository detalleProductosRepository;

    public DetalleProductoServiceImpl(DetalleProductosRepository detalleProductosRepository) {
        this.detalleProductosRepository = detalleProductosRepository;
    }

    @Override
    public List<DetalleProducto> consultarTodos() {
        return detalleProductosRepository.findAll();
    }

    @Override
    public DetalleProducto crear(DetalleProducto detalleProducto) {
        return detalleProductosRepository.save(detalleProducto);

    }

}
