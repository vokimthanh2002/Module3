package baitapmap;

import java.util.TreeMap;

public class Text {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0]= new Student(1,"Thanh","da nang");
        students[1]= new Student(2,"Nam","Quang Nam");
        students[2]= new Student(3,"Ly","Quang Ngai");
        TreeMap<Integer,Student> treeMap = new TreeMap<>();
        treeMap.put(1,students[0]);
        treeMap.put(2,students[1]);
        treeMap.put(3,students[2]);
        System.out.println( treeMap);
    }
}
