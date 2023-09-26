import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

public class Impresora {
    private int maxTinta = 10;
    ArrayDeque<Integer> tinta = new ArrayDeque<>(maxTinta);
    Queue<String> documentos = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        Impresora impresora = new Impresora();
        Scanner sc = new Scanner(System.in);
        String mensaje, documento;
        impresora.cargarTinta();

        do {
            System.out.println("Desea imprimir un documento? S/N: ");
            mensaje = sc.nextLine();
            if (mensaje.equals("S")) {
                System.out.println("Ingrese el nombre del documento: ");
                documento = sc.nextLine();
                impresora.documentos.offer(documento);
            }
        } while (!mensaje.equals("N"));

        if (impresora.documentos.isEmpty()) {
            System.out.println("No hay documentos para imprimir");
        } else {
            while (!impresora.documentos.isEmpty()) {
                System.out.println("Imprimiendo...");
                System.out.println(impresora.documentos.poll());
                System.out.println("-1 tinta " + impresora.tinta.pop());
            }
        }
        if (impresora.tinta.isEmpty()) {
            System.out.println("El cartucho de tinta esta vacio. ¿Quieres cargarlo de nuevo? S/N");
            String mensaje2 = sc.nextLine();
            if (mensaje2.equals("S")) {
                impresora.cargarTinta();
            }
        }
        sc.close();
    }

    public void cargarTinta() {
        System.out.println("Poniendo cartucho...");
        for (int i = 0; i < maxTinta; i++) {
            tinta.push(i);
        }
    }
}
