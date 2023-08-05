package arraylistandlinkedlist;

import java.util.ArrayList;

public class KhoiTaoArrayList {
    public static void main(String[] args) {
        // khoi tao
        ArrayList<String> list = new ArrayList<String>(20);
        list.add("Java");
        list.add("C++");
        list.add("C++");
        list.add("Python");
        list.add("Php");
        //duyet su dung for
//        for(int i=0; i<list.size();i++){
//            System.out.println(list.get(i));
//        }
        //duyet su dung for each
//        for(String str:  list){
//            System.out.println(str);
//        }
        // sử dụng Iterator - hiển thị các phần tử của list
//        Iterator<String> iterator = list.iterator();
//        System.out.println("cac phan tu co trong list la:" );
//        while(iterator.hasNext()){
//            System.out.println((String) iterator.next());
//        }
        // sử dụng ListIterator - hiển thị các phần tử của list
//        ListIterator<String> listIterator = list.listIterator();
//        System.out.println("cac phan tu co trong list la:");
//        while(listIterator.hasNext()){
//            System.out.println((String)listIterator.next());
//        }
        // cac mothod addAll,remoteAll,retainAll
        //method addALl
//        ArrayList<String> list1= new ArrayList<String>();
//        list1.addAll(list);
//        System.out.println(list1);

        // giu lai cac phan tu co trong list2
//        ArrayList<String> list2= new ArrayList<String>();
//        list2.add("Php");
//        list.retainAll(list2);
//        System.out.println(list);

        // xoa tat ca cac phan tu co trong list2
//        ArrayList<String> list2= new ArrayList<String>();
//        list2.add("C++");
//        list2.add("Php");
//        list.removeAll(list2);
//        System.out.println(list);
        // truy cap phan tu cua arrayList qua mothod get
//        System.out.println(list.get(3));
        // cap  nhat gia tri cua phan tu trong arrayList
//        System.out.println(list);
//        System.out.println(list.set(3,"cap nhat java"));
//        System.out.println(list);

        // xoa phan tu trong arraylist
//        System.out.println("so phan tu ban dau "+ list.size());
//        System.out.println("arrayList: "+ list);
//        list.clear();
//        System.out.println("so phan tu sau khi clear "+ list.size());
//        System.out.println("arrayList: "+ list);

        // method remove
//        System.out.println(list);
//        list.remove(3);
//        System.out.println(list);
        // kiem tra phan tu co ton tai trong arrayList qua method contrains
        // co chua tra ve true
//        System.out.println(list.contains("C++"));
        // khong chua tra ve false
//        System.out.println(list.contains("contains"));
        // tim kiem vi tri xuat hien cua mot phan tu trong arrayList
        //Co xuat hien tra ve vi tri
//        System.out.println(list.indexOf("C++"));
        // khong co tra ve -1
//        System.out.println(list.indexOf("khong co"));
        // tim kiem vi tri phan tu xuat hien cuoi cung trong arraylist
//        System.out.println(list.lastIndexOf("C++"));
        // chuyen arrayList sang mang array
//        Object[] array = list.toArray();
//        for(int  i=0; i<array.length;i++){
//            System.out.println(array[i]);
//        }
        // tao arrayList co kieu generic la string
        // show arraylist bang iterator
//        Iterator<String> iterator= list.iterator();
//        while (iterator.hasNext()){
//            System.out.print(iterator.next()+ ",");
//        }
        // show arrayList bang for-each
//        for(String str: list){
//            System.out.print(str+ ",");
//        }
        // show list through index
//        for(int i=0; i<list.size();i++){
//            System.out.print(list.get(i)+",");
//        }

    }
}