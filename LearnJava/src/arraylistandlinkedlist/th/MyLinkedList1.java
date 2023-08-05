package arraylistandlinkedlist.th;

public class MyLinkedList1 {
    private class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    private Node head;// doi tuong cua lop Node
    private int numNodes;// so phan tu trong danh sach xac dinh bang 0
    public MyLinkedList1(Object data) {
        head = new Node(data);
    }

    // Cai dat phuong thuc add
    public void add(int index, Object data) {
        Node temp = head;
        Node holder ;
        for(int i=0;i<index-1 && temp!=null;i++){
            temp=temp.next;
        }
        holder= temp.next;
        temp.next = new Node(data);
        temp.next.next=holder;
        numNodes++;
    }

    //cai dat phuong thuc addFirst
    public void addFirst(Object data){
        Node temp= head;
        head= new Node(data);
        head.next= temp;
        numNodes++;
    }
    //cai dat phuong thuc get
    public Node get(int index){
        Node tmp=  head;
        for(int i=0; i<index;i++){
            tmp=tmp.next;
        }
        return tmp;
    }
    // cai dat phuong thuc printList
    public void printList(){
        Node tmp= head;
        while(tmp!=null){
            System.out.print(tmp.data+" ");
            tmp=tmp.next;
            if(tmp!=null){
                System.out.print("-->");
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList1 ll = new MyLinkedList1(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.add(4,9);
        ll.add(4,9);
        ll.printList();
    }

}

