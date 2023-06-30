import java.time.LocalTime;
import java.util.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        int opcion;
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
        // Siniestro
        Siniestros siniestro = new Siniestros();
        System.out.println("Ingrese la fecha del accidente (dd/mm/aaaa): ");
        siniestro.setFecha(sc.nextLine());
        System.out.println("Ingrese la hora del accidente (formato 24hs HH:mm): ");
        LocalTime hora = LocalTime.parse(sc.nextLine());
        siniestro.setHora(hora);
        System.out.println("Ingrese el lugar del accidente: ");
        siniestro.setLugar(sc.nextLine());
        System.out.println("Describa como ocurrio el accidente: ");
        siniestro.setDescripcion(sc.nextLine());
        System.out.println(
                "Ingrese el tipo de daños ocasionados: Vehicular [1] | Material [2] | Lesiones [3] | Salir [0]");
        siniestro.setDaño(sc.nextInt());
        if (siniestro.getDaño() == 1) {
            MenuVehiculos.menu1();
        } else if (siniestro.getDaño() == 2) {

            System.out
                    .println("Para ingresar a bienes inmuebles [1] (Viviendas, estructuras, edificios, etc.)");
            System.out.println(
                    "Para ingresar a bienes muebles [2] (Maquinarias no rodantes, herramientas, bicicletas, etc.)");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    MenuMateriales1.menu();
                    break;
                case 2:
                    MenuMateriales2.menu();
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } else if (siniestro.getDaño() == 3) {
            MenuLesiones.menu3();
        } else {
            System.out.println("Opcion invalida");
        }
        sc.close();
    }
}