package Java1;

import java.util.Scanner;

public class InSNT {
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
        System.out.println("BAN MUON IN CAC SO NGUYEN TO NHO  HON BAO NHIEU:  ");
        int  number= sc.nextInt();
        for(int i=1; i<=number;i++){
            if(check(i))
                System.out.print(i+" ");
        }
    }
}
