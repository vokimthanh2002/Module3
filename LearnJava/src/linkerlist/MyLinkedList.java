package linkerlist;

public class MyLinkedList {
    public static void main(String[] args) {
        Node n1= new Node(1);
        Node n2= new Node(3);
        Node n3= new Node(4);
        n1.next= n2;
        n2.next= n3;
        Node.printLinkedList(n1);
        Node.printLinkedList(n2);
        //add elements to head
        n1= n1.addToHead(n1,0);
        Node.printLinkedList(n1);
        //add elements to tail
        n1=Node.addToTail(n1,5);
        Node.printLinkedList(n1);
        //add elements to index
        n1=Node.addToIndex(n1,15,1);
        Node.printLinkedList(n1);
//        n1=Node.removeFirst(n1);
//        n1=Node.removeFirst(n1);
//        Node.printLinkedList(n1);
//        n1=Node.removeLast(n1);
//        n1=Node.removeLast(n1);
//        n1=Node.removeLast(n1);
//        n1=Node.removeLast(n1);
//        Node.printLinkedList(n1);
        n1=Node.removeIndex(n1,2);
        n1=Node.removeIndex(n1,2);
        n1=Node.removeIndex(n1,2);
        n1=Node.removeIndex(n1,2);
        n1=Node.removeIndex(n1,2);
        n1=Node.removeIndex(n1,2);
        n1=Node.removeIndex(n1,1);
        n1=Node.removeIndex(n1,0);
        Node.printLinkedList(n1);

    }

}
