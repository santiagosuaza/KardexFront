package com.example.Backend.service;

import com.example.Backend.model.Producto;
import com.example.Backend.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

class ProductoServiceTest {

    ProductoRepository productoRepository = mock(ProductoRepository.class);



    @Test
    void crearExitoso() {
        ProductoService productoService = new ProductoService(productoRepository);
        Producto producto = new Producto("Santiago",3,"",0D,"");
        when(productoRepository.save(Mockito.any(Producto.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        Producto resultado = productoService.crear(producto);
        assertEquals(producto,resultado);
    }

    @Test
    void consultar() {

    }

    @Test
    void consultarTodos() {
        ProductoService productoService = new ProductoService(productoRepository);
        Producto producto = new Producto("Santiago",3,"",0D,"");
        List<Producto> productos = Arrays.asList(producto);
       when(productoRepository.findAll()).thenReturn(productos);
        List<Producto> resultado = productoService.consultarTodos();
        assertEquals(productos,resultado);
    }


    @Test
    void eliminar() {
    }

    @Test
    void bajarStock() {
       ProductoService productoService = new ProductoService(productoRepository);
        Producto productoBD = new Producto( "Santiago",3,"",0D,"");
        Integer cantidadBD =  productoBD.getCantidad();
        when(productoRepository.findById((any()))).thenReturn(Optional.of(productoBD));
        when(productoService.bajarStock((any()))).thenReturn(productoBD);
        assertEquals(productoBD.getCantidad(),
                (Integer)(cantidadBD-1));


    }
}