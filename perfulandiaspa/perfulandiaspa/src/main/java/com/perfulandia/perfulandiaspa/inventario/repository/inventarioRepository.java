package com.perfulandia.perfulandiaspa.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.perfulandiaspa.inventario.model.inventarioModel;

@Repository
public interface inventarioRepository extends JpaRepository<inventarioModel, Integer> {

}
