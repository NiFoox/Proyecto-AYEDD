
import java.util.Scanner;

public class MenuMateriales2 {
    static String facturatitulo, descincidente;
    static int presupuesto, dniprop;
    static boolean poseeCober, denuncia, DNIdelprop, certificado, poseefotos, poseefacturatitulo;

    public static void main(String[] args) {

    }

    public static void menu() {
        int opcion;
        Scanner sc = new Scanner(System.in);
        System.out.println("Si posee cobertura de seguro ingrese: 1 | No posee ingrese: 2 | Salir: 0 ");
        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                poseeCober = true;
                break;
            case 2:
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
            } else if (sc.nextInt() == 2) {
                denuncia = false;
            } else {
                System.out.println("Opcion invalida");
            }
            System.out.println("¿Tiene certificado de cobertura? 1: Si | 2: No ");
            if (sc.nextInt() == 1) {
                certificado = true;
            } else if (sc.nextInt() == 2) {
                certificado = false;
            } else {
                System.out.println("Opcion invalida");
            }
        } else if (poseeCober == false) {
            sc.nextLine(); // limpiar bufer
            System.out.println("Describa como sucedio el incidente");
            descincidente = sc.nextLine();
        }

        System.out.println(
                "¿Posee factura/titulo donde se describa el bien dañado y el nombre de su propietario? 1: Si | 2: No ");
        if (sc.nextInt() == 1) {
            System.out.println("Posee factura/titulo");
            poseefacturatitulo = true;
        } else if (sc.nextInt() == 2) {
            System.out.println("No posee factura/titulo");
            poseefacturatitulo = false;
        } else {
            System.out.println("Opcion invalida");
        }
        System.out.println("¿Posee DNI del propietario del bien dañado? 1: Si | 2: No ");
        if (sc.nextInt() == 1) {
            DNIdelprop = true;
        } else if (sc.nextInt() == 2) {
            DNIdelprop = false;
        } else {
            System.out.println("Opcion invalida");
        }
        System.out.println("¿Posee Fotos? 1: Si | 2: No");
        if (sc.nextInt() == 1) {
            poseefotos = true;
        } else if (sc.nextInt() == 2) {
            poseefotos = false;
        } else {
            System.out.println("Opcion invalida");
        }

        if (poseefacturatitulo && DNIdelprop && poseefotos) {
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
