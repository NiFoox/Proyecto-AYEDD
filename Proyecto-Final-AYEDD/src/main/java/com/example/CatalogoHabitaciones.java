package com.example;

import java.util.ArrayList;
import java.util.List;

public class CatalogoHabitaciones {
    private List<Habitacion> habitaciones;

    public CatalogoHabitaciones() {
        habitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public List<Habitacion> buscarHabitacionesDisponibles() {
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.isDisponible()) {
                habitacionesDisponibles.add(habitacion);
            }
        }
        return habitacionesDisponibles;
    }

    public Habitacion buscarHabitacionPorNumero(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                return habitacion;
            }
        }
        return null;
    }

    public List<Habitacion> ordenarHabitacionesPorPrecio() {
        List<Habitacion> habitacionesOrdenadas = new ArrayList<>(habitaciones);

        for (int i = 1; i < habitacionesOrdenadas.size(); i++) {
            Habitacion actual = habitacionesOrdenadas.get(i);
            int j = i - 1;

            while (j >= 0 && habitacionesOrdenadas.get(j).getPrecio() > actual.getPrecio()) {
                habitacionesOrdenadas.set(j + 1, habitacionesOrdenadas.get(j));
                j--;
            }

            habitacionesOrdenadas.set(j + 1, actual);
        }

        return habitacionesOrdenadas;
    }

    public List<Habitacion> ordenarHabitacionesPorNumero() {
        List<Habitacion> habitacionesOrdenadas = new ArrayList<>(habitaciones);
        for (int i = 1; i < habitaciones.size(); i++) {
            Habitacion habitacionActual = habitacionesOrdenadas.get(i);
            int j = i - 1;

            while (j >= 0 && habitaciones.get(j).getNumero() > habitacionActual.getNumero()) {
                habitaciones.set(j + 1, habitaciones.get(j));
                j--;
            }
            habitaciones.set(j + 1, habitacionActual);
        }
        return habitacionesOrdenadas;
    }

    public List<Habitacion> filtrarHabitacionesPorPrecio(double precioMinimo, double precioMaximo) {
        List<Habitacion> habitacionesDisponibles = buscarHabitacionesDisponibles();

        List<Habitacion> habitacionesFiltradas = new ArrayList<>();

        for (Habitacion habitacion : habitacionesDisponibles) {
            double precioHabitacion = habitacion.getPrecio();
            if (precioHabitacion >= precioMinimo && precioHabitacion <= precioMaximo) {
                habitacionesFiltradas.add(habitacion);
            }
        }

        return habitacionesFiltradas;
    }
}