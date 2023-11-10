package com.example;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;

public class GuardarReservas {
    public static void guardarReservasEnJSON(List<Reserva> reservas) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.registerModule(new JavaTimeModule());

            File file = new File("reservas.json");
            objectMapper.writeValue(file, reservas);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
