package com.example.Backend.acl.controller;

import com.example.Backend.model.DetalleProducto;
import com.example.Backend.service.IDetalleProductoService;
import com.example.Backend.service.IProductoService;
import com.example.Backend.model.Producto;
import com.example.Backend.acl.entities.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProductoController {
    @Autowired
    IProductoService productoService;

    @Autowired
    IDetalleProductoService detalleProductoService;

    @DeleteMapping("/api/eliminar/{id}")
    public Respuesta borrar(@PathVariable("id") long id) {
        boolean eliminar = productoService.eliminar(id);
        if (eliminar) {
            return new Respuesta("Eliminado", 201, true, "Eliminado");
        } else {
            return new Respuesta("No Eliminado", 201, false, "No eliminado");
        }

    }

    @PostMapping("/api/guardar")
    public Producto guardar(@RequestBody Producto producto) {
        return productoService.crear(producto);
    }


    @GetMapping(value = "api/consultar/{id}")
    public Producto consultar(@PathVariable("id") long id) {
        return productoService.consultar(id);
    }

    @GetMapping(value = "api/bajarStock/{id}")
    public void bajarStock(@PathVariable long id) {
        productoService.bajarStock(id);
    }

    @GetMapping("api/consultar-productos")
    public List<Producto> consultarProductos() { return productoService.consultarTodos(); }

    @GetMapping("api/consultar-detalle")
    public List<DetalleProducto> consultarDetalle() { return detalleProductoService.consultarTodos(); }

}
