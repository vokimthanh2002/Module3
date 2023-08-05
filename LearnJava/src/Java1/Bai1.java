package Java1;

import java.util.Scanner;

public class Bai1 {
    private static Scanner sc =new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Nhap a:");
        double a= sc.nextInt();
        System.out.println("Nhap b:");
        double b= sc.nextInt();
        System.out.println("Nhap c:");
        double c= sc.nextInt();

        double dt= b*b-4*a*c;
        double x1=(-b+Math.sqrt(dt))/2*a;
        double x2=(-b-Math.sqrt(dt))/2*a;
        if(dt<0){
            System.out.println("pt vo  nghiem  ");
        }else if(dt==0)
            System.out.println("phuong trinh co 1 nghiem  duy nhat "+x1);
        else
            System.out.println("x1= "+x1+"  x2= "+x2);
    }
}
