package Java1;

import java.util.Scanner;

public class SNTDAUTIEN {
    private static Scanner sc=  new Scanner(System.in);

    public static boolean check(int number){
        if(number<2)
            return false;
        for (int i=2;i<=Math.sqrt(number);i++)
            if(number%i==0)
                return false;
        return true;
    }

    public static void main(String[] args){
        int  N=10000;
        int s=0;
        while (N >=10000 && N<=99999){
            if(check(N)){
                System.out.print(N+" ");
                s++;
            }
            N++;
        }
        System.out.print(s);
    }
}
