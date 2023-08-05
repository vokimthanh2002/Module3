package Java1;
import java.util.ArrayList;
import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        int number,d=0;
        System.out.println("ban muon in bao  nhieu so");
        Scanner sc= new Scanner(System.in);
        number=sc.nextInt();
        int f0=0;
        int f1=1;
        int  s=0;
        while (d<number){
            arrayList.add(f0);
            int  fn=f0+f1;
            f0=f1;
            f1=fn;
            d++;
        }
        System.out.println(arrayList);
        for(int x : arrayList){
            s=s+x;
        }
        System.out.println("Tong la: "+s);
        System.out.println(arrayList.get(number-1));
    }
}
