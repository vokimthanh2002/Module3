package Java1;

import java.util.Scanner;

public class SapXepNoiBot {
    public static Scanner  sc= new Scanner(System.in);
    public static int[] selectionSort(int[] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[i]){
                    int tempt = a[i];
                    a[i]=a[j];
                    a[j]=tempt;
                }
            }
        }
        return a;
    }
    public static void Duyet(int [] arr){
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println("");
    }
    public static void Nhap(int[] arr, int n){
        for(int i=0;i<n;i++){
            System.out.print("Nhap vao phan tu thu "+i+" : ");
            arr[i]=sc.nextInt();
        }
    }

    public static void main(String[]  args){
        int[] arr;
        int number;
        System.out.println("Nhap vao bao nhieu so:  ");
        number= sc.nextInt();
        arr=new int[number];
        Nhap(arr,number);
        Duyet(arr);
        selectionSort(arr);
        Duyet(arr);
    }
}
