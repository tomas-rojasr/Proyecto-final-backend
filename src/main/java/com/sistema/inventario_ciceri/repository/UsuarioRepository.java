package com.sistema.inventario_ciceri.repository;

import com.sistema.inventario_ciceri.entity.Usuarios;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuarios, Long>  {
    Usuarios findByUsernameAndPassword(String username, String password);

}


