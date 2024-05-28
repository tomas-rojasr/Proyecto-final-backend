package com.sistema.inventario_ciceri.controller;

import com.sistema.inventario_ciceri.entity.Usuarios;
import com.sistema.inventario_ciceri.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/login")
@RestController
public class UsuarioController {

    private Map<String, Object> response = new HashMap<String, Object>();

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/ingresar")
    public ResponseEntity<?> login(@RequestBody Usuarios loginRequest) {
        try {
            Usuarios usuario = usuarioService.login(loginRequest.getUsername(), loginRequest.getPassword());
            if (usuario != null) {
                // Login exitoso, devolver el usuario o un mensaje de éxito
                response.put("message", "Ingreso Correcto");
                response.put("status", true);
                return ResponseEntity.ok(response);
            } else {
                // Credenciales inválidas, devolver un mensaje de error
                response.put("message", "Credenciales inválidas");
                response.put("status", false);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        } catch (Exception e) {
            // Manejar cualquier excepción y devolver un mensaje de error genérico
            response.put("message", e.getMessage());
            response.put("status", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        }
    }
}
