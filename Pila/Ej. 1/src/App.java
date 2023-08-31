import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero 1");
        int n1 = sc.nextInt();
        System.out.println("Ingrese el numero 2");
        int n2 = sc.nextInt();
        esMultiplo(n1,n2);
        if(esMultiplo(n1, n2)==true){
            System.out.println("El numero " + n1 + " es multiplo de "+ n2);
        }
        sc.close();
    }
    public static boolean esMultiplo (int num1, int num2){
        if(num1 % num2==0){
            return true;
        }
        else{
            return false;
        }
       
    }
}
