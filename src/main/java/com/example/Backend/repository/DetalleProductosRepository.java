package com.example.Backend.repository;

import com.example.Backend.model.DetalleProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleProductosRepository extends JpaRepository<DetalleProducto, Long> {
}
