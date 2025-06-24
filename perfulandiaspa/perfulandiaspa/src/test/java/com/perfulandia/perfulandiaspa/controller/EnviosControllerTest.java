package com.perfulandia.perfulandiaspa.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.perfulandia.perfulandiaspa.envios.model..EnviosModel;
import com.perfulandia.perfulandiaspa.envios.service.enviosService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.time.LocalDate;

@WebMvcTest(EnviosController.class)
public class EnviosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private enviosService enviosService;

    @Autowired
    private ObjectMapper objectMapper;

    private Enviosmodel envio;

    @BeforeEach

    void setUp() {
        envio = new EnviosModel();
        envio.setId(1L);
        envio.setNombreCliente("Juan Pérez");
        envio.setDireccionEnvio("Calle Falsa 123");
        envio.setTelefonoCliente("987654321");
        envio.setEstadoEnvio("EN PROCESO");
        envio.setFechaEnvio(LocalDate.now().toString()); // O ajusta el tipo de fecha si es Date
        envio.setCostoCliente("4500.0"); // Usa el tipo de dato correcto



        -
    }

}
