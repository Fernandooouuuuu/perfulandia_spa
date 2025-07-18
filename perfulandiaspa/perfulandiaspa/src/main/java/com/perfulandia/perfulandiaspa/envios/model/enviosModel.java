package com.perfulandia.perfulandiaspa.envios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "envios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnviosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "direccion_envio")
    private String direccionEnvio;

    @Column(name = "telefono_cliente")
    private String telefonoCliente;

    @Column(name = "estado_envio")
    private String estadoEnvio;

    @Column(name = "fecha_envio")
    private String fechaEnvio;

    @Column(name = "costo_envio")
    private Double costoEnvio;
}
