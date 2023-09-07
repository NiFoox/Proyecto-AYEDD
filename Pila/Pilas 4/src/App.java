import java.util.Stack;
public class App {
    public static void main(String[] args) throws Exception {
        Stack<Integer> pila = new Stack<Integer>();
    
    for (int i = 0; i < 5; i++) {
      pila.push(i);
    }
    
    while (!pila.empty()) {
         System.out.println(pila.pop());
    }
    for (int i = 5; i < 10; i++) {
      pila.push(i);
    }
    while (!pila.empty()) {
         System.out.println(pila.pop());
    }
}
}
