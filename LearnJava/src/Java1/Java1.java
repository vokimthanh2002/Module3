package Java1;

import java.util.ArrayList;
import java.util.Scanner;

public class Java1 {
    public static boolean checkSNT(int number){
        if(number<2)
            return false;
        for(int i=2; i<=Math.sqrt(number);i++){
            if(number%i==0)
                return false;
        }
        return true;
    }
    public static boolean checkSTN(int number){
        ArrayList<Integer> list = new ArrayList<Integer>();
        do {
            list.add(number%10);
            number= number/10;
        }while(number>0);
        int size= list.size();
        for(int i=0; i<size/2;i++){
            if(list.get(i)!=list.get(size-i-1))
                return false;
        }
        return true;
    }
    public static boolean checkSNT1(int number){
        ArrayList<Integer> list = new ArrayList<Integer>();
        do {
            list.add(number%10);
            number= number/10;
        }while(number>0);
        int size= list.size();
        for(int i=0; i<size; i++)
            if (!checkSNT(list.get(i))) {
                return false;
            }
        return true;
    }
    public static boolean SumSNT(int number){
        ArrayList<Integer> list = new ArrayList<Integer>();
        do {
            list.add(number%10);
            number= number/10;
        }while(number>0);
        int size= list.size();
        int s=0;
        for(int i=0; i<size; i++){
            s=s+list.get(i);
        }
        if(checkSNT(s)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int d=0;
      for(int i=1000000; i<10000000;i++){
          if(checkSNT(i) && checkSTN(i) && checkSNT1(i) && SumSNT(i)){
              System.out.println(i+" ");
              d++;
          }
      }
        System.out.println("Tong cac so yeu cau: "+d);
    }
}
