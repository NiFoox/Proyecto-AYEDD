import java.util.*;

public class App {
    static int presupuesto;

    public static void main(String[] args) throws InterruptedException {

        // Denunciante
        Scanner sc = new Scanner(System.in);
        Denunciantes denunciante = new Denunciantes();
        System.out.println("Ingrese su nombre: ");
        denunciante.setNombre(sc.nextLine());
        System.out.println("Ingrese su apellido: ");
        denunciante.setApellido(sc.nextLine());
        System.out.println("Ingrese su correo: ");
        denunciante.setCorreo(sc.nextLine());
        System.out.println("Ingrese su dni: ");
        denunciante.setDni(sc.nextInt());
        sc.nextLine();
        System.out.println("Ingrese su número de teléfono: ");
        denunciante.setNumtel(sc.nextLine());
        // Vehiculos
        System.out.println("Ingrese la cantidad de vehiculos involucrados: ");
        int cantvehiculos = sc.nextInt();
        Vehiculos vehiculos[] = new Vehiculos[cantvehiculos];
        sc.nextLine();
        for (int i = 0; i < cantvehiculos; i++) {
            vehiculos[i] = new Vehiculos();
            System.out.println("Ingrese la marca del vehiculo: ");
            vehiculos[i].setMarca(sc.nextLine());
            System.out.println("Ingrese el modelo del vehiculo: ");
            vehiculos[i].setModelo(sc.nextLine());
            System.out.println("Ingrese el año del modelo: ");
            vehiculos[i].setAño(sc.nextInt());
            sc.nextLine();
            System.out.println("Ingrese la patente del vehiculo: ");
            vehiculos[i].setPatente(sc.nextLine());
        }
        System.out.println(vehiculos[0]);
        // Siniestro
        Siniestros siniestro = new Siniestros();
        System.out.println("Ingrese la fecha del accidente: ");
        siniestro.setFecha(sc.nextLine());
        System.out.println("Ingrese la hora del accidente (formato 24hs): ");
        siniestro.setHora(sc.nextInt());
        sc.nextLine();
        System.out.println("Ingrese el lugar del accidente: ");
        siniestro.setLugar(sc.nextLine());
        System.out.println("Describa como ocurrio el accidente: ");
        siniestro.setDescripcion(sc.nextLine());
        System.out.println("Ingrese el o los tipos de daños ocasionados(Vehicular (V)// Material (M)// Lesiones(L)): ");
        siniestro.setDaño(sc.next().charAt(0));
        menu();
        if (presupuesto != 0) {
            System.out.println("Su denuncia fue aprobada");
        }
    }

    private static void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println(
                    "Ingrese el tipo de daño ocasionado: ------------ 1: Vehicular | 2: Material | 3: Lesiones | 0: Salir : ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    boolean poseeFranq = false;
                    boolean poseeCober = false;
                    boolean denuncia = false;
                    boolean certificado = false;
                    boolean nota = false;
                    int opcion2;
                    System.out.println(
                            "Si posee cobertura de seguro ingrese: 1 | Si posee franquicia ingrese: 2 | Salir: 0 ");
                    opcion2 = sc.nextInt();
                    switch (opcion2) {
                        case 1:
                            poseeCober = true;
                            poseeFranq = false;
                            break;
                        case 2:
                            poseeFranq = true;
                            poseeCober = false;
                            break;
                        case 0:
                            // Salir del bucle
                            break;
                        default:
                            System.out.println("Opcion invalida");
                            break;
                    }
                    if (poseeCober == true) {
                        System.out.println("¿Presento denuncia interna? 1: Si | 2: No  ");
                        if (sc.nextInt() == 1) {
                            denuncia = true;
                        } else {
                            denuncia = false;
                        }
                        System.out.println("¿Tiene certificado de cobertura? 1: Si | 2: No ");
                        if (sc.nextInt() == 1) {
                            certificado = true;
                        } else if (sc.nextInt() == 2) {
                            certificado = false;
                        } else {
                            System.out.println("Opcion invalida");
                        }
                    }
                    if (poseeFranq == true) {

                        System.out.println("¿Tiene una Nota de franquicia emitida por su aseguradora? 1: Si | 2: No ");
                        if (sc.nextInt() == 1) {
                            nota = true;
                        } else if (sc.nextInt() == 2) {
                            nota = false;
                        } else {
                            System.out.println("Opcion invalida");
                        }
                    }
                    boolean licencia = false, tarjeta_verde = false, fotos = false;
                    System.out.println("¿Posee licencia de conducir? 1: Si | 2: No ");
                    if (sc.nextInt() == 1) {
                        licencia = true;
                    } else if (sc.nextInt() == 2) {
                        licencia = false;
                    } else {
                        System.out.println("Opcion invalida");
                    }
                    System.out.println("¿Posee tarjeta verde? 1: Si | 2: No ");
                    if (sc.nextInt() == 1) {
                        tarjeta_verde = true;
                    } else if (sc.nextInt() == 2) {
                        tarjeta_verde = false;
                    } else {
                        System.out.println("Opcion invalida");
                    }
                    System.out.println("¿Posee fotos del vehiculo? 1: Si | 2: No ");
                    if (sc.nextInt() == 1) {
                        fotos = true;
                    } else if (sc.nextInt() == 2) {
                        fotos = false;
                    } else {
                        System.out.println("Opcion invalida");
                    }
                    if ((poseeCober || poseeFranq) && ((denuncia && certificado || nota) && licencia && tarjeta_verde
                            && fotos)) {
                        System.out.println(
                                "Su denuncia de siniestro fue aprobada. Porfavor ingrese un presupuesto para la reparación y la empresa se pondra en contacto: ");
                        presupuesto = sc.nextInt();

                    }
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 0:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}