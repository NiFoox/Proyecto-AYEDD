import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> pila = new Stack<>();
        String expresion;
        boolean estaBalanceado = false;
        System.out.println("Ingresa la expresión: ");
        expresion = scanner.nextLine();
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if (caracter == '(' || caracter == '[' || caracter == '{') {
                pila.push(caracter);
            } else if (caracter == ')' || caracter == ']' || caracter == '}') {
                pila.pop();
            }
        }
        if (pila.isEmpty()) {
            estaBalanceado = true;
        } else if (!pila.isEmpty()) {
            estaBalanceado = false;
        }
        System.out.println(estaBalanceado);
        scanner.close();
    }
}
