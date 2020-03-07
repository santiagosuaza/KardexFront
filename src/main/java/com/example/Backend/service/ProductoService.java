package com.example.Backend.service;

import com.example.Backend.dao.ProductoDao;
import com.example.Backend.model.Producto;
import com.example.Backend.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements ProductoDao {

    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto crear(Producto producto) {
        Producto productoBd = productoRepository.save(producto);
        return producto;
    }
    @Override
    public Producto consultar(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User Id" + id));
    }


    @Override
    public List<Producto> consultarTodos() {
        List<Producto> list = productoRepository.findAll();
        return list;
    }

    @Override
    public boolean eliminar(Long id) {
        return productoRepository.findById(id).map(
                producto -> {
                    productoRepository.delete(producto);
                    return true;
                }
        ).orElse(false);
    }

    @Override
    public Producto bajarStock(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid User Id" + id));
        if (producto != null) {
            producto.setCantidad(producto.getCantidad() - 1);
            productoRepository.save(producto);
            return producto;
        } else {
            return null;
        }

    }

}

