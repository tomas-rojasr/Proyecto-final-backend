package com.sistema.inventario_ciceri.controller;

import com.sistema.inventario_ciceri.entity.Productos;
import com.sistema.inventario_ciceri.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.Map;
import java.util.HashMap;

@RequestMapping("/api/productos")
@RestController
public class ProductosController {

    private Map<String, Object> response = new HashMap<String, Object>();

    @Autowired
    private ProductosService productosService;

    @GetMapping("/lista")
    public Iterable<Productos> list() {
        return productosService.findAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> obtenerProducto(@PathVariable Integer id){
        return ResponseEntity.ok(productosService.findById(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarProducto(@RequestBody Productos productos){
        try {
            response.put("message", "Producto creado exitosamente");
            response.put("status", true);
            response.put("data", this.productosService.guardar(productos));
            return ResponseEntity.ok(response);
        }catch (Exception ex){
            response.put("message", ex.getMessage());
            response.put("status", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Integer id, @RequestBody Productos producto){
        try {
            response.put("message", "Producto actualizado exitosamente");
            response.put("status", true);
            response.put("data", this.productosService.update(id,producto));
            return ResponseEntity.ok(response);
        }catch (Exception ex){
            response.put("message", ex.getMessage());
            response.put("status", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Integer id) {
        try {
            response.put("message", "Producto eliminado exitosamente");
            response.put("status", true);
            this.productosService.deletedById(id);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            response.put("message", ex.getMessage());
            response.put("status", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
