package com.perfulandia.perfulandiaspa.envios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.perfulandia.perfulandiaspa.envios.model.EnviosModel;
import com.perfulandia.perfulandiaspa.envios.service.EnviosService;

@RestController
@RequestMapping("/api/envios")
public class EnviosController {
    @Autowired
    private EnviosService enviosService;

    @PostMapping
    public EnviosModel crearVenta(@RequestBody EnviosModel venta) {
        return EnviosService.crearVenta(venta);
    }

    @GetMapping
    public List<EnviosModel> listarVentas() {
        return EnviosService.listarVentas();
    }

    @GetMapping("/{id}")
    public EnviosModel obtenerVentaPorId(@PathVariable Long id) {
        return EnviosService.obtenerVentaPorId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminarVenta(@PathVariable Long id) {
        try {
            EnviosService.eliminarVenta(id);
            return "Venta eliminada con éxito";
        } catch (Exception e) {
            return "Error al eliminar la venta: " + e.getMessage();
        }
    }


}
