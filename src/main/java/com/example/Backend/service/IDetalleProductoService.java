package com.example.Backend.service;

import com.example.Backend.model.DetalleProducto;

import java.util.List;

public interface IDetalleProductoService {


    List<DetalleProducto> consultarTodos();

    DetalleProducto crear(DetalleProducto detalleProducto);


}
