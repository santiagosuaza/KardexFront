package com.example.Backend.service;

import com.example.Backend.model.DetalleProducto;
import com.example.Backend.model.Producto;
import com.example.Backend.model.TipoMovimiento;
import com.example.Backend.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    private ProductoRepository productoRepository;
    private IDetalleProductoService detalleProductoService;

    public ProductoServiceImpl(
            ProductoRepository productoRepository,
            DetalleProductoServiceImpl detalleProductoService
    ) {
        this.detalleProductoService = detalleProductoService;
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto crear(Producto producto) {
        productoRepository.save(producto);
        detalleProductoService.crear(new DetalleProducto("Producto Creado", producto.getCantidad(), TipoMovimiento.SUBIO));
        return producto;
    }

    @Override
    public Producto consultar(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User Id" + id));
    }


    @Override
    public List<Producto> consultarTodos() {
        return productoRepository.findAll();

    }

    @Override
    public boolean eliminar(Long id) {
        return productoRepository.findById(id).map(
                producto -> {
                    productoRepository.delete(producto);
                    detalleProductoService.crear(new DetalleProducto("Producto eliminado", 0, TipoMovimiento.BAJO));
                    return true;
                }
        ).orElse(false);
    }

    @Override
    public Producto bajarStock(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User Id" + id));
        if ( producto.getCantidad() > 0) {
            detalleProductoService.crear(new DetalleProducto("Bajo del stock", producto.getCantidad(), TipoMovimiento.BAJO));
            producto.setCantidad(producto.getCantidad() - 1);
            productoRepository.save(producto);
            return producto;
        } else {
            throw  new IllegalArgumentException("No hay cantidades disponibles");
        }

    }

}

