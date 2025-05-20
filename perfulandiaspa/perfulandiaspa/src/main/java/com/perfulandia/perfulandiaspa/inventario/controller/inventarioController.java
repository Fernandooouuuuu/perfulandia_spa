package com.perfulandia.perfulandiaspa.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.perfulandiaspa.inventario.model.inventarioModel;
import com.perfulandia.perfulandiaspa.inventario.service.productoService;

@RestController
@RequestMapping("/api/inventario")
public class inventarioController {

    @Autowired
    private productoService inventarioService;

    @GetMapping
    public ResponseEntity<List<inventarioModel>> listar() {
        List<inventarioModel> inventarios = inventarioService.findAll();
        if (inventarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(inventarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<inventarioModel> buscar(@PathVariable Integer id){
        try {
            inventarioModel inventario = inventarioService.findById(id);
            if (inventario == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(inventario);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<inventarioModel> crear(@RequestBody inventarioModel inventario) {
        try {
            inventarioModel nuevoInventario = inventarioService.save(inventario);
            return ResponseEntity.status(201).body(nuevoInventario);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<inventarioModel> actualizar(@PathVariable Integer id, @RequestBody inventarioModel inventario) {
        try {
            inventarioModel inventarioExistente = inventarioService.findById(id);
            if (inventarioExistente == null) {
                return ResponseEntity.notFound().build();
            }
            inventario.setId(id);
            inventarioModel inventarioActualizado = inventarioService.save(inventario);
            return ResponseEntity.ok(inventarioActualizado);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            inventarioModel inventario = inventarioService.findById(id);
            if (inventario == null) {
                return ResponseEntity.notFound().build();
            }
            inventarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}
