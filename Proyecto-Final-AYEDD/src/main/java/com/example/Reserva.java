package com.example;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;

@JsonSerialize(using = SerializadorDeReservas.class)
public class Reserva {
    private Habitacion habitacion;
    private Usuario usuario;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    public Reserva(Habitacion habitacion, Usuario usuario, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.habitacion = habitacion;
        this.usuario = usuario;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }
}
