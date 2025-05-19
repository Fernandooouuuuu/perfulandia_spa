package com.perfulandia.perfulandiaspa.usuario.controller;

import com.perfulandia.perfulandiaspa.usuario.model.*;
import com.perfulandia.perfulandiaspa.usuario.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Usuario")
public class usuarioController {

    @Autowired
    private usuarioService usuarioService;

    @PostMapping
    public usuarioModel crearUsuario(@RequestBody usuarioModel usuario){
        return usuarioService.save(usuario);
    }

    @GetMapping
    public List<usuarioModel> listarUsuario() {
        return usuarioService.findAll();
    }
    
    @GetMapping("/{id}")
    public usuarioModel obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioService.findById(id);
    }
    
    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Long id){
    try{
        usuarioService.delete(id);
        return "Usuario eliminado";
    } catch (Exception e){
        return "Usuario no encontrado";
        }
    }
}
