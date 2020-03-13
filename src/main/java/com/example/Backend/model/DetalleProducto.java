package com.example.Backend.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private String fecha ;



    public DetalleProducto(String descripcion, Integer cantidadStock, TipoMovimiento tipoMovimiento, String fecha ) {
        this.descripcion = descripcion;
        this.cantidadStock = cantidadStock;
        this.tipoMovimiento = tipoMovimiento;
        this.fecha=fecha;


    }

    public DetalleProducto() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

}
