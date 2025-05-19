package com.perfulandia.perfulandiaspa.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.perfulandiaspa.ventas.model.Venta;
import com.perfulandia.perfulandiaspa.ventas.repository.ventaRepository;

@Service
public class ventaService {

    @Autowired
    private ventaRepository ventaRepository;

    public Venta guardarVenta(Venta v) {
        return ventaRepository.save(v);
    }

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    public Venta buscarVentaPorId(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public boolean eliminarVenta(Long id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
