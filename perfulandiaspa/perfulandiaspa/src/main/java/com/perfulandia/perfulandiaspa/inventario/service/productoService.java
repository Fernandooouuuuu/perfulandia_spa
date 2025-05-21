package com.perfulandia.perfulandiaspa.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.perfulandiaspa.inventario.model.inventarioModel;
import com.perfulandia.perfulandiaspa.inventario.repository.inventarioRepository;

@Service
public class productoService {

    @Autowired
    private inventarioRepository inventarioRepository;

    public List<inventarioModel> findAll() {
        return inventarioRepository.findAll();
    }

    public inventarioModel findById(Integer id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    public inventarioModel save(inventarioModel inventario) {
        return inventarioRepository.save(inventario);
    }

    public void deleteById(Integer id) {
        inventarioRepository.deleteById(id);
    }
}

