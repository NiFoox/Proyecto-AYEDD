import java.util.*;

public class Vehiculos {
    static String marca, modelo, patente;
    static int año;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la marca de su vehiculo: ");
        Vehiculos.marca = sc.nextLine();
        System.out.println("Ingrese el modelo de su vehiculo: ");
        Vehiculos.modelo = sc.nextLine();
        System.out.println("Ingrese el año del modelo: ");
        Vehiculos.año = sc.nextInt();
        System.out.println("Ingrese la patente de su vehiculo: ");
        Vehiculos.patente = sc.nextLine();
        System.out.println(Vehiculos.marca);
        System.out.println(Vehiculos.modelo);
        System.out.println(Vehiculos.año);
        System.out.println(Vehiculos.patente);
        sc.close();

    }

    public static String getMarca() {
        return marca;
    }

    public static String getModelo() {
        return modelo;
    }

    public static String getPatente() {
        return patente;
    }

    public static int getAño() {
        return año;
    }
}
