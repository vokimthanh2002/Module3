package Java1;

import java.util.Scanner;

public class Rever {
    public static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Nhap bao nhieu so vao mang");
        int so= sc.nextInt();
        int [] array= new int[so];
        nhapMang(array,so);
        inMang(array);
        rever(array);
        inMang(array);
    }
    public static  void nhapMang(int[] array,int so){

        for(int i=0; i<so;i++){
            System.out.print("Nhap phan tu thu "+i+" : ");
            array[i]= sc.nextInt();
        }
    }
    public static void inMang(int[] array){
        for(int i: array){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void rever(int[] array){
        int tg;
        for(int i=0; i<array.length/2;i++){
            tg= array[i];
            array[i]=array[array.length-1-i];
            array[array.length-1-i]=tg;
        }
    }
}
