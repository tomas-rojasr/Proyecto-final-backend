package com.sistema.inventario_ciceri.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String nombre;
    private String descripcion;
    private Long precio;
    private Integer activo;
    private LocalDateTime createdAt;
}