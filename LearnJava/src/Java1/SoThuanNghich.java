package Java1;

import java.util.ArrayList;
import java.util.Objects;

public class SoThuanNghich {
    public static void main(String[] args) {
        int d=0;
        for(int i=100000;i<1000000;i++){
            if(check(i)){
                System.out.println(i);
                d++;
            }

        }
        System.out.println("TONG CAC SO THUAN NGHICH:"+d);

    }
    public static boolean check(int number) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        do {
            list.add(number%10);
            number= number/10;
        }while (number>0);
        int size = list.size();
        for(int i=0; i<size/2;i++){
            if(!Objects.equals(list.get(i), list.get(size - i - 1))){
                return false;
            }
        }
        return true;
    }
}
