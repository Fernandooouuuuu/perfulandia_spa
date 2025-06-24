package com.perfulandia.perfulandiaspa.envios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.perfulandiaspa.envios.model.EnviosModel;
import com.perfulandia.perfulandiaspa.envios.repository.EnviosRepository;

@Service
public class EnviosService {
    @Autowired
    private EnviosRepository enviosRepository;

    public EnviosModel crearEnvio(EnviosModel venta) {
        return enviosRepository.save(venta);
    }

    public List<EnviosModel> listarEnvio() {
        return enviosRepository.findAll();
    }

    public EnviosModel obtenerEnvioPorId(Long id) {
        return enviosRepository.findById(id).orElse(null);
    }

    public void eliminarEnvio(Long id) {
        enviosRepository.deleteById(id);
    }
    
}
