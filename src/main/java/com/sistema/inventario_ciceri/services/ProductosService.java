package com.sistema.inventario_ciceri.services;

import com.sistema.inventario_ciceri.entity.Productos;

import java.util.List;
import java.util.Optional;

public interface ProductosService {

    List<Productos> findAll();
    public Productos guardar(Productos productos) throws Exception;

    public Optional<Productos> findById(Integer id);

    public Productos update(Integer id, Productos producto) throws Exception;

    public void deletedById(Integer id)  throws Exception;


}
