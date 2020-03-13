package com.example.Backend.service;

import com.example.Backend.model.Producto;

import java.util.List;

public interface IProductoService {
    Producto crear(Producto producto);

    Producto consultar(Long id);

    List<Producto> consultarTodos();

    boolean eliminar(Long id);

    Producto bajarStock(Long id);
}
