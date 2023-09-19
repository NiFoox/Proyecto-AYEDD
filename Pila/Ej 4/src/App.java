import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String nombre, materia;
        int n, i = 0;
        System.out.println("Ingrese la cantidad de alumnos: ");
        n = sc.nextInt();
        sc.nextLine();
        String AlumnosMaterias[][] = new String[2][n];
        Queue<String> algebra = new LinkedList<>();
        Queue<String> analisis = new LinkedList<>();
        Queue<String> fisica = new LinkedList<>();
        Queue<String> algoritmos = new LinkedList<>();
        while (i < n) {
            System.out.println("Materia: ");
            materia = sc.nextLine();
            AlumnosMaterias[0][i] = materia;
            System.out.println("Nombre: ");
            nombre = sc.nextLine();
            AlumnosMaterias[1][i] = nombre;
            i++;
        }
        for (int j = 0; j < i; j++) {
            if (AlumnosMaterias[0][j].equals("algebra")) {
                algebra.offer(AlumnosMaterias[1][j]);
            } else if (AlumnosMaterias[0][j].equals("analisis")) {
                analisis.offer(AlumnosMaterias[1][j]);
            } else if (AlumnosMaterias[0][j].equals("fisica") || AlumnosMaterias[0][j].equals("física")) {
                analisis.offer(AlumnosMaterias[1][j]);
            } else if (AlumnosMaterias[0][j].equals("algoritmos")) {
                analisis.offer(AlumnosMaterias[1][j]);
            }
        }
        System.out.println("Los alumnos que rinden algebra son:");
        while (!algebra.isEmpty()) {
            System.out.println(algebra.poll());
        }
        System.out.println("Los alumnos que rinden fisica son:");
        while (!fisica.isEmpty()) {
            System.out.println(fisica.poll());
        }
        System.out.println("Los alumnos que rinden analisis son:");
        while (!analisis.isEmpty()) {
            System.out.println(analisis.poll());
        }
        System.out.println("Los alumnos que rinden algoritmos son:");
        while (!algoritmos.isEmpty()) {
            System.out.println(algoritmos.poll());
        }
        sc.close();
    }
}
