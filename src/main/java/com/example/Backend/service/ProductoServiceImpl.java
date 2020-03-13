package com.example.Backend.service;

import com.example.Backend.model.DetalleProducto;
import com.example.Backend.model.Producto;
import com.example.Backend.model.TipoMovimiento;
import com.example.Backend.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service

public class ProductoServiceImpl implements IProductoService {
    Date date=new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        productoRepository.save(producto);
        detalleProductoService.crear(new DetalleProducto("Producto Creado", producto.getCantidad(), TipoMovimiento.SUBIO,dateFormat.format(date))
        );
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
                    detalleProductoService.crear(new DetalleProducto("Producto eliminado", 0, TipoMovimiento.BAJO,null));
                    return true;
                }
        ).orElse(false);
    }

    @Override
    public Producto bajarStock(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User Id" + id));
        if ( producto.getCantidad() > 0) {
            producto.setCantidad(producto.getCantidad()-1 );
            detalleProductoService.crear(new DetalleProducto("Bajo del stock", producto.getCantidad(), TipoMovimiento.BAJO,dateFormat.format(date)
            ));
            productoRepository.save(producto);
            return producto;
        } else {
            throw  new IllegalArgumentException("No hay cantidades disponibles");
        }

    }

}

