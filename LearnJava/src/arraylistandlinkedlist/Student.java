package arraylistandlinkedlist;

import java.util.ArrayList;

public class Student {
    private String name;
    private int age;

    public Student(){

    }
    public Student( String name, int age){
        this.name= name;
        this.age= age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString(){
        return "name: "+ name + " agr: "+ age;
    }

    public static void main(String[] args) {
        ArrayList<Student> arrayList=  new ArrayList<Student>();
        Student st1= new Student("Tran Ngoc tien",13);
        Student st2= new Student("Vo Kim Thanh", 18);
        Student st3= new Student("Tran Ngoc tien",13);
        arrayList.add(st1);
        arrayList.add(st2);
        arrayList.add(st3);
        for(Student st:arrayList){
            System.out.println(st.getAge());
        }
    }

}