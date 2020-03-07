package com.example.Backend.controller;

import com.example.Backend.dao.ProductoDao;
import com.example.Backend.model.Producto;
import com.example.Backend.model.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ProductoController {
    @Autowired
    ProductoDao productoDao;

    @DeleteMapping("/api/eliminar/{id}")
    public  Respuesta Borrar (@PathVariable ("id") long id){
        boolean eliminar = productoDao.eliminar(id);
        if (eliminar) {
            return new Respuesta("Eliminado",201,true,"Eliminado");
        } else {
            return new Respuesta("No Eliminado",201,false,"No eliminado");
        }

    }

    @PostMapping("/api/guardar")
    public Producto Guardar (@RequestBody Producto producto){return  productoDao.crear(producto);}


    @GetMapping(value = "api/consultar/{id}")
    public Producto consultar(@PathVariable ("id") long id){ return  productoDao.consultar(id);}

    @GetMapping(value = "api/bajarStock/{id}")
    public void bajarStock(@PathVariable  long id){ productoDao.bajarStock(id);}

    @GetMapping("api/consultarTodos")
    public List<Producto> ConsultarTodos(){
        return  productoDao.consultarTodos();
    }

}
