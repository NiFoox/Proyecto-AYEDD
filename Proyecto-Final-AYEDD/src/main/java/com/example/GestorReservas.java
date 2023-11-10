package com.example;

import java.util.ArrayList;
import java.util.List;

public class GestorReservas {
    private List<Reserva> reservas;

    public GestorReservas() {
        reservas = new ArrayList<>();
    }

    public void crearReserva(Reserva reserva) {
        reservas.add(reserva);
        reserva.getHabitacion().setDisponible(false);
    }

    public List<Reserva> obtenerReservas() {
        return reservas;
    }

    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva);

        reserva.getHabitacion().setDisponible(true);
    }
}
