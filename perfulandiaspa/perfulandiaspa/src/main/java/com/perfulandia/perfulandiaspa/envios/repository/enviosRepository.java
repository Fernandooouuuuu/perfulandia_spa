package com.perfulandia.perfulandiaspa.envios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.perfulandiaspa.envios.model.enviosModel;

@Repository
public interface enviosRepository extends JpaRepository<enviosModel, Long> {

}
