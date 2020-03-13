package com.example.Backend.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "detalle_producto")
public class DetalleProducto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_registro")
    private Long id;
    private String descripcion;
    private Integer cantidadStock;
    private TipoMovimiento tipoMovimiento;

    @CreatedDate
    private Date date;

    public DetalleProducto(String descripcion, Integer cantidadStock, TipoMovimiento tipoMovimiento) {
        this.descripcion = descripcion;
        this.cantidadStock = cantidadStock;
        this.tipoMovimiento = tipoMovimiento;
    }
}
