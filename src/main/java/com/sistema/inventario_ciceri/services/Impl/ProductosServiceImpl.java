package com.sistema.inventario_ciceri.services.Impl;

import com.sistema.inventario_ciceri.entity.Productos;
import com.sistema.inventario_ciceri.repository.ProductosRepository;
import com.sistema.inventario_ciceri.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    ProductosRepository productosRepository;

    @Override
    public List<Productos> findAll() {
        return productosRepository.findAll();
    }

    @Override
    public Productos guardar(Productos productos) throws Exception {
        return productosRepository.save(productos);
    }

    @Override
    public Optional<Productos> findById(Integer id) {
        return productosRepository.findById(id);
    }

    @Override
    public Productos update(Integer id, Productos producto) throws Exception {
        Optional<Productos> productoActualizar = productosRepository.findById(id);
        if(productoActualizar.isEmpty()){
            throw new Exception("Registro con nombre : "+ producto.getNombre() +" no encontrado." );
        }
        productoActualizar.get().setActivo(producto.getActivo());
        productoActualizar.get().setNombre(producto.getNombre());
        productoActualizar.get().setDescripcion(producto.getDescripcion());
        productoActualizar.get().setPrecio(producto.getPrecio());
        return productosRepository.save(productoActualizar.get());
    }

    @Override
    public void deletedById(Integer id)  throws Exception {
        productosRepository.deleteById(id);

    }
}
