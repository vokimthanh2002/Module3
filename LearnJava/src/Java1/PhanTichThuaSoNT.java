package Java1;

import java.util.Scanner;

public class PhanTichThuaSoNT {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap vao so: ");
        int number= sc.nextInt();
        phanTich(number);
        }
    public static boolean SNT(int number){
        if(number<2)
            return false;
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0)
                return  false;                                                               
        }
        return true;
    }
    public static void phanTich(int number){
        for(int i=2; i<=number;i++){
            while (SNT(i) && number%i==0){
                System.out.print(i+" ");
                number = number /i;
            }
        }
    }
}
