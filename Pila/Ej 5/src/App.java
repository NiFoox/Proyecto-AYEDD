import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Queue<String> colaPares = new LinkedList<>();
        Queue<String> colaImpares = new LinkedList<>();
        System.out.println("Ingrese su numero de dni: ");
        String dni = sc.nextLine();
        char ultimoCaracter = dni.charAt(dni.length() - 1);
        while (!dni.equals("0")) {
            if (ultimoCaracter % 2 == 0) {
                colaPares.offer(dni);
            } else {
                colaImpares.offer(dni);
            }
            System.out.println("Ingrese su numero de dni: ");
            dni = sc.nextLine(); // Leer el siguiente DNI
            ultimoCaracter = dni.charAt(dni.length() - 1); // Actualizar el último carácter
        }
        while (!colaPares.isEmpty()) {
            System.out.println("Los dni pares son: " + colaPares.poll());
        }
        while (!colaImpares.isEmpty()) {
            System.out.println("Los dni impares son: " + colaImpares.poll());
        }
        sc.close();
    }
}