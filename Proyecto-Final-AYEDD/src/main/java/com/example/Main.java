package com.example;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        int opcion;
        CatalogoHabitaciones catalogo = new CatalogoHabitaciones();
        GestorReservas gestorReservas = new GestorReservas();
        Queue<Reserva> colaReservas = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        // Agregar algunas habitaciones al catálogo
        catalogo.agregarHabitacion(new Habitacion(101, "Doble", 150.0));
        catalogo.agregarHabitacion(new Habitacion(102, "Individual", 100.0));
        catalogo.agregarHabitacion(new Habitacion(201, "Doble", 180.0));

        do {
            System.out.println("Menú Principal:");
            System.out.println("1. Ver habitaciones disponibles");
            System.out.println("2. Realizar una reserva");
            System.out.println("3. Ver mis reservas");
            System.out.println("4. Cancelar una reserva");
            System.out.println("5. Mostrar habitaciones ordenadas por precio");
            System.out.println("6. Mostrar habitaciones ordenadas por número");
            System.out.println("7. Filtrar habitaciones por precio");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Habitaciones Disponibles:");
                    List<Habitacion> habitacionesDisponibles = catalogo.buscarHabitacionesDisponibles();
                    habitacionesDisponibles
                            .forEach(habitacion -> System.out.println("Número: " + habitacion.getNumero() + ", Tipo: "
                                    + habitacion.getTipo() + ", Precio: " + habitacion.getPrecio() + " USD por noche"));
                    break;

                case 2:
                    System.out.print("Ingrese su nombre completo: ");
                    String nombreUsuario = scanner.nextLine();

                    int dniUsuario = 0;
                    boolean entradaValidaDNI = false;

                    do {
                        System.out.print("Ingrese su DNI (de 6 a 8 dígitos): ");
                        try {
                            dniUsuario = scanner.nextInt();
                            scanner.nextLine();
                            if (String.valueOf(dniUsuario).length() >= 6 && String.valueOf(dniUsuario).length() <= 8) {
                                entradaValidaDNI = true;
                            } else {
                                System.out.println("El DNI debe tener entre 6 y 8 dígitos.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("DNI inválido. Debe ingresar un número entero entre 6 y 8 dígitos.");
                            scanner.nextLine();
                        }
                    } while (!entradaValidaDNI);

                    System.out.print("Ingrese su correo electrónico: ");
                    String correoUsuario = scanner.nextLine();

                    int numeroHabitacion = 0;
                    boolean entradaValidaNH = false;

                    do {
                        try {
                            System.out.print("Seleccione una habitación (ingrese el número de habitación): ");
                            numeroHabitacion = scanner.nextInt();
                            scanner.nextLine();
                            entradaValidaNH = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Número de habitación inválido. Debe ingresar un número entero.");
                            scanner.nextLine();
                        }
                    } while (!entradaValidaNH);

                    System.out.print("Fecha de entrada (yyyy-MM-dd): ");
                    String fechaEntradaStr = scanner.nextLine();

                    System.out.print("Fecha de salida (yyyy-MM-dd): ");
                    String fechaSalidaStr = scanner.nextLine();

                    try {
                        LocalDate fechaEntrada = LocalDate.parse(fechaEntradaStr);
                        LocalDate fechaSalida = LocalDate.parse(fechaSalidaStr);

                        Habitacion habitacionSeleccionada = catalogo.buscarHabitacionPorNumero(numeroHabitacion);

                        if (habitacionSeleccionada != null && habitacionSeleccionada.isDisponible()) {
                            if (fechaSalida.isAfter(fechaEntrada)) {
                                Reserva reserva = new Reserva(habitacionSeleccionada,
                                        new Usuario(nombreUsuario, correoUsuario, "", dniUsuario), fechaEntrada,
                                        fechaSalida);
                                gestorReservas.crearReserva(reserva);
                                colaReservas.offer(reserva);
                                System.out.println("Reserva realizada con éxito y agregada a la cola de reservas.");
                            } else {
                                System.out.println(
                                        "La fecha de salida no puede ser anterior o igual a la fecha de entrada.");
                            }
                        } else {
                            System.out.println("La habitación seleccionada no está disponible.");
                        }
                    } catch (Exception e) {
                        System.out.println(
                                "Error al procesar las fechas. Asegúrese de que estén en el formato correcto (yyyy-MM-dd).");
                    }
                    break;

                case 3:
                    System.out.println("Mis Reservas:");
                    List<Reserva> misReservas = gestorReservas.obtenerReservas();
                    for (Reserva reserva : misReservas) {
                        System.out.println("Número de habitación: " + reserva.getHabitacion().getNumero());
                        System.out.println("Fechas de entrada y salida: " + reserva.getFechaEntrada() + " - "
                                + reserva.getFechaSalida());

                        long diasHospedaje = ChronoUnit.DAYS.between(reserva.getFechaEntrada(),
                                reserva.getFechaSalida());

                        double presupuesto = reserva.getHabitacion().getPrecio() * diasHospedaje;
                        System.out.println("El precio total a pagar es: " + presupuesto + " USD");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el número de habitación de la reserva que desea cancelar: ");
                    int numeroHabitacionCancelar = scanner.nextInt();
                    scanner.nextLine();

                    for (Reserva reserva : gestorReservas.obtenerReservas()) {
                        if (reserva.getHabitacion().getNumero() == numeroHabitacionCancelar) {
                            gestorReservas.cancelarReserva(reserva);
                            System.out.println("Reserva cancelada con éxito.");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Habitaciones ordenadas por precio:");
                    List<Habitacion> habitacionesOrdenadasPorPrecio = catalogo.ordenarHabitacionesPorPrecio();
                    habitacionesOrdenadasPorPrecio.forEach(habitacion -> System.out.println("Número: "
                            + habitacion.getNumero() + ", Precio: " + habitacion.getPrecio() + " USD por noche"));
                    break;

                case 6:
                    System.out.println("Habitaciones ordenadas por número:");
                    List<Habitacion> habitacionesOrdenadasPorNumero = catalogo.ordenarHabitacionesPorNumero();
                    habitacionesOrdenadasPorNumero.forEach(habitacion -> System.out
                            .println("Número: " + habitacion.getNumero() + ", Tipo: " + habitacion.getTipo()));
                    break;

                case 7:
                    System.out.print("Ingrese el precio mínimo: ");
                    double precioMinimo = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Ingrese el precio máximo: ");
                    double precioMaximo = scanner.nextDouble();
                    scanner.nextLine();

                    List<Habitacion> habitacionesFiltradas = catalogo.filtrarHabitacionesPorPrecio(precioMinimo,
                            precioMaximo);
                    if (habitacionesFiltradas.isEmpty()) {
                        System.out.println("No se encontraron habitaciones dentro del rango de precio especificado.");
                    } else {
                        habitacionesFiltradas.forEach(habitacion -> System.out.println("Número: "
                                + habitacion.getNumero() + ", Precio: " + habitacion.getPrecio() + " USD por noche"));
                    }
                    break;

                case 8:
                    System.out.println("Gracias por utilizar nuestro sistema de reservas. ¡Hasta la próxima!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 8);
        GuardarReservas.guardarReservasEnJSON(gestorReservas.obtenerReservas());
        scanner.close();
    }
}