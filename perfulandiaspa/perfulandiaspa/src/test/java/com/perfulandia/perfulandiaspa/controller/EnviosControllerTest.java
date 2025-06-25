package com.perfulandia.perfulandiaspa.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.perfulandia.perfulandiaspa.envios.controller.EnviosController;
import com.perfulandia.perfulandiaspa.envios.model.EnviosModel;
import com.perfulandia.perfulandiaspa.envios.service.EnviosService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    private EnviosService enviosService;

    @Autowired
    private ObjectMapper objectMapper;

    private EnviosModel envio;

    @BeforeEach

    void setUp() {
        envio = new EnviosModel();
        envio.setId(1L);
        envio.setNombreCliente("Juan Pérez");
        envio.setDireccionEnvio("Calle 123");
        envio.setTelefonoCliente("987654321");
        envio.setEstadoEnvio("EN PROCESO");
        envio.setFechaEnvio(LocalDate.now().toString()); // O ajusta el tipo de fecha si es Date
        envio.setCostoEnvio(4500.0); // Usa el tipo de dato correcto
    }

    @Test
    public void TestObtenerEnviosPorId() throws Exception{
        when(enviosService.listarEnvios()).thenReturn(List.of(envio));

        mockMvc.perform(get("/api/envios")
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].nombreCliente").value("Juan Pérez"))
            .andExpect(jsonPath("$[0].direccionEnvio").value("Calle 123"))
            .andExpect(jsonPath("$[0].telefonoCliente").value("987654321"))
            .andExpect(jsonPath("$[0].estadoEnvio").value("EN PROCESO"))
            .andExpect(jsonPath("$[0].fechaEnvio").value(envio.getFechaEnvio()))
            .andExpect(jsonPath("$[0].costoEnvio").value(4500.0));
    }

    @Test
    public void testCrearEnvio() throws Exception{
        when(enviosService.crearEnvio(envio)).thenReturn(envio);

        mockMvc.perform(post("/api/envios")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(envio)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.nombreCliente").value("Juan Pérez"));

    }

    @Test
    void testEliminarEnvio() throws Exception {
        mockMvc.perform(delete("/api/envios/1"))
        .andExpect(status().isOk());
    }

        
    }


