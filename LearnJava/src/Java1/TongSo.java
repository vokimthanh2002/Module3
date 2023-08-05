package Java1;

import java.util.Scanner;

public class TongSo {
    private static Scanner sc= new Scanner(System.in);

    public static int Sum(int n){
        int total= 0;
        do {
            total= total+ n%10;
            n=n/10;
        }while (n>0);
        return total;
    }

    public static void main(String[] args) {
        System.out.println("input  number: ");
        int number  =  sc.nextInt();
        System.out.println(Sum(number));
    }
}
