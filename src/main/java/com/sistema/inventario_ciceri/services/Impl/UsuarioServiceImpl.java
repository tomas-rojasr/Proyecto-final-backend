package com.sistema.inventario_ciceri.services.Impl;

import com.sistema.inventario_ciceri.entity.Productos;
import com.sistema.inventario_ciceri.entity.Usuarios;
import com.sistema.inventario_ciceri.repository.ProductosRepository;
import com.sistema.inventario_ciceri.repository.UsuarioRepository;
import com.sistema.inventario_ciceri.services.ProductosService;
import com.sistema.inventario_ciceri.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuarios login(String username, String password) {
        return usuarioRepository.findByUsernameAndPassword(username, password);
    }


}
