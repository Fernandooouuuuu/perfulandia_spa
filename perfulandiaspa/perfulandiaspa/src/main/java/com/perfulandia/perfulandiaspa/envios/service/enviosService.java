package com.perfulandia.perfulandiaspa.envios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.perfulandiaspa.envios.model.enviosModel;
import com.perfulandia.perfulandiaspa.envios.repository.enviosRepository;

@Service
public class enviosService {
    @Autowired
    private enviosRepository enviosRepository;

    public enviosModel crearVenta(enviosModel venta) {
        return enviosRepository.save(venta);
    }

    public List<enviosModel> listarVentas() {
        return enviosRepository.findAll();
    }

    public enviosModel obtenerVentaPorId(Long id) {
        return enviosRepository.findById(id).orElse(null);
    }

    public void eliminarVenta(Long id) {
        enviosRepository.deleteById(id);
    }
    
}
