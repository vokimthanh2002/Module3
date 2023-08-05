package Java1;

import java.util.Scanner;

public class SNT {
 public static boolean isPrimeNumber(int so){
     if(so<2){
         return false;
     }
     for(int i=2;i<=Math.sqrt(so);i++){
             if(so%i==0)
                 return false;
         }
     return true;
}
    public static void main(String[] args) {
        System.out.println("Các số nguyên tố nhỏ hơn 100 là: ");
        for (int i = 0; i < 100; i++) {
            if (isPrimeNumber(i)) {
                System.out.print(i + " ");
            }
        }
    }
}

