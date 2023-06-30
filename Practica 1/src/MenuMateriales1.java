
import java.util.Scanner;

public class MenuMateriales1 {
    static String imp;
    static int presupuesto, dniprop;
    static boolean poseeCober, denuncia, certificado, DNIdelprop, poseeimp, poseefotos,
            poseePresupRepa;

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
        }

        System.out.println("¿Posee DNI del propietario del bien dañado? 1: Si | 2: No ");
        if (sc.nextInt() == 1) {
            DNIdelprop = true;
        } else if (sc.nextInt() == 2) {
            DNIdelprop = false;
        } else {
            System.out.println("Opcion invalida");
        }
        System.out.println(
                "¿Posee Impuesto donde se describa el domicilio del bien dañado y el nombre de su propietario? 1: Si | 2: No");
        if (sc.nextInt() == 1) {
            poseeimp = true;
            System.out.println("Ingrese el impuesto");
            imp = sc.nextLine();
        } else if (sc.nextInt() == 2) {
            poseeimp = false;
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
        System.out.println("¿Posee presupuestos de reparación? 1: Si | 2: No");
        if (sc.nextInt() == 1) {
            poseePresupRepa = true;
        } else if (sc.nextInt() == 2) {
            poseePresupRepa = false;
        } else {
            System.out.println("Opcion invalida");
        }

        if ((denuncia || certificado) && DNIdelprop && poseeimp && poseefotos && poseePresupRepa) {
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