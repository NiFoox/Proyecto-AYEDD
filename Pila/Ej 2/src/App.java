import java.util.Stack;
public class App {
    public static void main(String[] args) throws Exception {
        Stack<Integer> pila = new Stack<>();
        pila.push(5);
        pila.push(2);
        pila.push(8);
        pila.push(2);
        pila.push(10);

        System.out.println("Pila original: " + pila);
        
        int viejo = 2;
        int nuevo = 20;
        reemplazar(pila, nuevo, viejo);
        
        System.out.println("Pila modificada: " + pila);
        
    }
    public static void reemplazar(Stack<Integer> pila, int nuevo, int viejo){
        Stack<Integer> pilaTemp = new Stack<>();

        while(!pila.isEmpty()){
            int elemento=pila.pop();
            if (elemento == viejo){
                pilaTemp.push(nuevo);
            }
            else{
                pilaTemp.push(elemento);
            }
        }
        while(!pilaTemp.isEmpty()){
            pila.push(pilaTemp.pop());
        }
    }
    
}


