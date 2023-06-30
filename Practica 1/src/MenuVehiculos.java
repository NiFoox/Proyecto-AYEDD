
import java.util.Scanner;

public class MenuVehiculos {
    static int presupuesto;
    static boolean poseeCober, poseeFranq, denuncia, certificado, nota, licencia, tarjeta_verde, fotos;

    public static void menu1() {
        int opcion;
        Scanner sc = new Scanner(System.in);
        System.out.println("Si posee cobertura de seguro ingrese: 1 | Si posee franquicia ingrese: 2 | Salir: 0 ");
        opcion = sc.nextInt();
        switch (opcion) {
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
            if (presupuesto > 0) {
                System.out.println("Su denuncia fue aprobada");
            }
            while (presupuesto <= 0) {
                System.out.println("El monto ingresado no es valido, porfavor ingrese un monto mayor a 0");
                presupuesto = sc.nextInt();
            }
        } else {
            System.out.println("Su denuncia no fue aprobada porque no cumple los requisitos necesarios");
        }
        sc.close();
    }
}
