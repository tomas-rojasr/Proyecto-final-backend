package com.sistema.inventario_ciceri.repository;

import com.sistema.inventario_ciceri.entity.Productos;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepository extends CrudRepository<Productos, Integer>  {

    @Transactional
    List<Productos> findAll();

}


