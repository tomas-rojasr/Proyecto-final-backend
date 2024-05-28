package com.sistema.inventario_ciceri.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "inventarios")
public class Inventarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id", nullable = true)
    private Productos productos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proveedor_id", nullable = true)
    private Proveedores proveedores;

    private Integer stock;

    private LocalDateTime createdAt;
}