package com.sistema.inventario_ciceri.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "formularioUsuario")
public class FormularioUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "formulario_id", nullable = true)
    private Formulario formulario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = true)
    private Usuarios usuario;

    private Boolean consultar;
    private Boolean actualizar;
    private Boolean crear;
    private Boolean borrar;
    private LocalDateTime createdAt;
}