package Java1;

import java.util.Scanner;

public class GiaiThua {
    public static int Giaithua(int so){
        int  s=1;
        for(int  i=1; i<=so;i++){
            s=s*i;
        }
        return s;
    }

    public static void main(String[]  args){
        int  number;
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap so: ");
        number=  sc.nextInt();
        System.out.printf(number+"!= "+Giaithua(number));
    }
}
