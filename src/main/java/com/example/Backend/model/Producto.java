package com.example.Backend.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_producto")
    private Long id;

    private String nombre;
    private Integer cantidad;
    private String detalle;
    private Double precio;
    private String categoria;

    public Producto(String nombre, Integer cantidad, String detalle, Double precio, String categoria) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.detalle = detalle;
        this.precio = precio;
        this.categoria = categoria;
    }
}


