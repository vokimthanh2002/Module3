package Java1;

import java.util.Scanner;

public class UCLNANDBBCNN {
    private static Scanner sc= new Scanner(System.in);

    public int  UCLN(int a, int  b){
        while (a!=b){
            if(a>b)
                a=a-b;
            else
                b=b-a;
        }
        return a;
    }
    public int BCNN(int a, int b){
        return (a * b) / UCLN(a, b);
    }

    public static void main(String[] args) {
        int a,b;
        System.out.println("NHAP A: ");
        a=sc.nextInt();
        System.out.println("NHAP B: ");
        b=sc.nextInt();
        UCLNANDBBCNN ub= new UCLNANDBBCNN();
        System.out.println(ub.UCLN(a,b));
        System.out.println(ub.BCNN(a,b));
    }
}
