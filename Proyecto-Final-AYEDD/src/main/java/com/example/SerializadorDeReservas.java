package com.example;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class SerializadorDeReservas extends JsonSerializer<Reserva> {
    @Override
    public void serialize(Reserva reserva, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("habitacionNumero", reserva.getHabitacion().getNumero());
        jsonGenerator.writeObjectField("fechaEntrada", reserva.getFechaEntrada());
        jsonGenerator.writeObjectField("fechaSalida", reserva.getFechaSalida());
        jsonGenerator.writeStringField("nombreUsuario", reserva.getUsuario().getNombre());
        jsonGenerator.writeNumberField("dniUsuario", reserva.getUsuario().getDni());
        jsonGenerator.writeStringField("mailUsuario", reserva.getUsuario().getCorreoElectronico());

        // Agrega más campos según sea necesario
        jsonGenerator.writeEndObject();
    }
}
