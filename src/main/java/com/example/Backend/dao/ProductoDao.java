package com.example.Backend.dao;

import com.example.Backend.model.Producto;
import com.example.Backend.model.Respuesta;

import java.util.List;

public interface ProductoDao {
    Producto crear(Producto producto);
    Producto consultar(Long id);
    List<Producto>consultarTodos();
    boolean eliminar(Long id);
    Producto bajarStock(Long id);
}
