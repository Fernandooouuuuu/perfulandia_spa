package com.perfulandia.perfulandiaspa.envios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.perfulandia.perfulandiaspa.envios.model.enviosModel;
import com.perfulandia.perfulandiaspa.envios.service.enviosService;

@RestController
@RequestMapping("/api/envios")
public class enviosController {
    @Autowired
    private enviosService enviosService;

    @PostMapping
    public enviosModel crearVenta(@RequestBody enviosModel venta) {
        return enviosService.crearVenta(venta);
    }

    @GetMapping
    public List<enviosModel> listarVentas() {
        return enviosService.listarVentas();
    }

    @GetMapping("/{id}")
    public enviosModel obtenerVentaPorId(@PathVariable Long id) {
        return enviosService.obtenerVentaPorId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminarVenta(@PathVariable Long id) {
        try {
            enviosService.eliminarVenta(id);
            return "Venta eliminada con éxito";
        } catch (Exception e) {
            return "Error al eliminar la venta: " + e.getMessage();
        }
    }


}
