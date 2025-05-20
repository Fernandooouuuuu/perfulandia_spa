package com.perfulandia.perfulandiaspa.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.perfulandiaspa.inventario.model.inventarioModel;

@Service
public class productoService {

    @Autowired
    private productoService productoService;

    public List<inventarioModel> findAll() {
        return productoService.findAll();
    }

    public inventarioModel findById(Integer id) {
        return productoService.findById(id);
    }

    public inventarioModel save(inventarioModel inventario) {
        return productoService.save(inventario);
    }

    public void deleteById(Integer id) {
        productoService.deleteById(id);
    }

}
