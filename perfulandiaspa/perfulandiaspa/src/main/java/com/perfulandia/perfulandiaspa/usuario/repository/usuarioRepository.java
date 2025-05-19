package com.perfulandia.perfulandiaspa.usuario.repository;

import com.perfulandia.perfulandiaspa.usuario.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface usuarioRepository extends JpaRepository<usuarioModel, Long>{

} 