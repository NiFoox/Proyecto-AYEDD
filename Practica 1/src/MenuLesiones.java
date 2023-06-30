
import java.util.Scanner;

public class MenuLesiones {
    static int presupuesto;
    static boolean poseeCober, denuncia, certificado, DNIdellesionado, informe, noposee;

    public static void main(String[] args) {

    }

    public static void menu3() {
        int opcion;
        Scanner sc = new Scanner(System.in);
        System.out.println("Si posee cobertura de seguro ingrese: 1 | No posee ingrese: 2 | Salir: 0 ");
        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                poseeCober = true;
                noposee = false;
                break;
            case 2:
                noposee = true;
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

        System.out.println("¿Posee DNI del lesionado? 1: Si | 2: No ");
        if (sc.nextInt() == 1) {
            DNIdellesionado = true;
        } else if (sc.nextInt() == 2) {
            DNIdellesionado = false;
        } else {
            System.out.println("Opcion invalida");
        }
        System.out.println("¿Posee Informe / certificado de centro de salud que realizo atencion? 1: Si | 2: No");
        if (sc.nextInt() == 1) {
            informe = true;
        } else if (sc.nextInt() == 2) {
            informe = false;
        } else {
            System.out.println("Opcion invalida");
        }

        if ((poseeCober || noposee) && ((denuncia && certificado) && DNIdellesionado && informe)) {
            System.out.println(
                    "Su denuncia de siniestro fue aprobada. Porfavor ingrese un presupuesto para el tratamiento del afectado y\n la empresa se pondra en contacto: ");
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