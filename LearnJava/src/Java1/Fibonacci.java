package Java1;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){
        int number;
        Scanner sc= new Scanner(System.in);
        System.out.print("Ban muon in bao nhieu  so: ");
        number=  sc.nextInt();
        for(int i=0;i<number;i++){
            System.out.print(fibonacci(i)+" ");
        }

    }
    public static int fibonacci(int n)
    {
        int f0=0;
        int f1=1;
        int fn=1;
        if(n<0){
            return -1;
        }else  if(n==0 || n==1){
            return n;
        }else{
            for(int i=2;i<n;i++){
                f0=f1;
                f1=fn;
                fn=f0+f1;
            }
        }
        return fn;
    }
}
