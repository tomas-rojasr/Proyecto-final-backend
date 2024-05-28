package com.sistema.inventario_ciceri.services;

import com.sistema.inventario_ciceri.entity.Productos;
import com.sistema.inventario_ciceri.entity.Usuarios;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public Usuarios login(String username, String password);

}
