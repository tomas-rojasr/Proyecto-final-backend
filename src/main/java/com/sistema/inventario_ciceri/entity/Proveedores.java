package com.sistema.inventario_ciceri.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "proveedores")
public class Proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String nit;
    private String razon_social;
    private LocalDateTime createdAt;
}