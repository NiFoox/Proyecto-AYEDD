import java.util.*;

public class Denunciantes {
    static String nombre, apellido, correo;
    static int dni, numtel;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        Denunciantes.nombre = sc.nextLine();
        System.out.println("Ingrese su apellido: ");
        Denunciantes.apellido = sc.nextLine();
        System.out.println("Ingrese su correo: ");
        Denunciantes.correo = sc.nextLine();
        System.out.println("Ingrese su dni: ");
        Denunciantes.dni = sc.nextInt();
        System.out.println("Ingrese su número de teléfono: ");
        Denunciantes.numtel = sc.nextInt();
        System.out.println(Denunciantes.nombre);
        System.out.println(Denunciantes.apellido);
        System.out.println(Denunciantes.correo);
        System.out.println(Denunciantes.dni);
        System.out.println(Denunciantes.numtel);
        sc.close();
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static String getCorreo() {
        return correo;
    }

    public static int getDni() {
        return dni;
    }

    public static int getNumtel() {
        return numtel;
    }

}
