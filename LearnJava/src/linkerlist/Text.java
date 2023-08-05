package linkerlist;
import java.util.LinkedList;

// dinh nghia mot lop node
public class Text {
    public static void main(String[] args) {
//        LinkedList<Integer> linkedList= new LinkedList<>();
//        linkedList.add(0);
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
//        // su dung vong lap for
//        System.out.println("cac phan tu trong linkerlist la: ");
//        for(int i=0;i<linkedList.size();i++){
//            System.out.print(linkedList.get(i));
//        }

        LinkedList<Character> linkedList = new LinkedList<>();
        linkedList.add('a');
        linkedList.add('b');
        linkedList.add('c');
        linkedList.add('d');
        // su dung foreach
        System.out.println("Cac phan tu co trong linkerlist la: ");
        for(char node: linkedList){
            System.out.println(node+ " ");
        }
        //remove, removeFirst,removeLast,removeAll
        linkedList.removeAll(linkedList);
        System.out.println("Cac phan tu co trong linkerlist la: ");
        for(char node: linkedList){
            System.out.println(node+ " ");
        }
        System.out.println(linkedList.size());
        //truy cap phan tu mothod get,getFirst,getLast
//        System.out.println(linkedList.get(2));
//        System.out.println(linkedList.getFirst());
//        System.out.println(linkedList.getLast());
        //cap nhat gia tri cua phan tu method set
//        linkedList.set(2,'t');
//        System.out.println("Cac phan tu co trong linkerlist la: ");
//        for(char node: linkedList ){
//            System.out.println(node);
//        }
        // addAll
//        LinkedList<Character> linkedList1= new LinkedList<>();
//        linkedList1.addAll(linkedList);
//        System.out.println("Cac phan tu co trong linkerlist la: ");
//        for(char node: linkedList){
//            System.out.println(node+ " ");
//        }
        // them phan tu tai vi tri bat ki
//        linkedList.add(2, 'r');
//        System.out.println("Cac phan tu co trong linkerlist la: ");
//        for(char node: linkedList){
//            System.out.println(node+ " ");
//        }
//        // addFirst, addLast;
//        linkedList.addFirst('t');
//        linkedList.addLast('g');
//        System.out.println("Cac phan tu co trong linkerlist la: ");
//        for(char node: linkedList){
//            System.out.println(node+ " ");
//        }
        // dung iterator
//        Iterator<Character> iterator= linkedList.iterator();
//        System.out.println("Cac phan tu co trong linkerlist la: ");
//        while (iterator.hasNext()){
//            System.out.println((Character) iterator.next());
//        }
        // dung Listiterator
//        ListIterator<Character> listIterator= linkedList.listIterator();
//        System.out.println("Cac phan tu co trong linkerlist la: ");
//        while (listIterator.hasNext()){
//            System.out.println((Character) listIterator.next());
//        }

    }
}
