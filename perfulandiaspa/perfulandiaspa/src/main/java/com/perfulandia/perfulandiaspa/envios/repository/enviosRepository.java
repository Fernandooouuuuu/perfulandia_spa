package com.perfulandia.perfulandiaspa.envios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.perfulandiaspa.envios.model.EnviosModel;

@Repository
public interface EnviosRepository extends JpaRepository<EnviosModel, Long> {

}
