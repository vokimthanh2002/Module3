package arraylistandlinkedlist.bt2;
public class MyLinkedList<E> {
    Node head;
    int numNodes;

    MyLinkedList(Object data){
        head= new Node(data);
        numNodes++;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getNumNodes() {
        return numNodes;
    }

    public void setNumNodes(int numNodes) {
        this.numNodes = numNodes;
    }

    // them phan tu khi biet index
    public  void addToIndex(int index, E e){
        if(index==0){
            addFirst(e);
        }else{
            Node temp= head;
            for(int i=0; i<index-1;i++){
                temp=temp.next;
            }
            Node holder= temp.next;
            temp.next= new Node(e);
            temp.next.next=holder;
        }
        numNodes++;
    }
    // them phan tu vao dau
    public void addFirst(E e){
        Node temp= head;
        head= new Node(e);
        head.next= temp;
        numNodes++;
    }
    //them phan tu vao cuoi
    public void addLast(E e){
        Node temp= head;
        while (temp.next!=null){
            temp=temp.next;
        }
        Node newNode= new Node(e);
        temp.next=newNode;
        numNodes++;
    }
    //in ra linkedList
    public void print(){
        Node temp=head;
        if(numNodes==0){
            System.out.println("LinhkedList empty");
        }else{
            while (temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
                if(temp!=null){
                    System.out.print("-->");
                }else{
                    System.out.println();
                }
            }
        }
    }
    // lay ve size hien tai
    public int size(){
        return numNodes;
    }
    // lay phan tu o vi tri i
    public E get(int index){
        return moveToIndex(index);
    }
    // lay phan tu o vi tri dau
    public E getFirst(){
        return (E) head.data;
    }
    // lay phan tu o vi tri cuoi cung
    public E getLast(){
        return moveToTail();
    }
    public E moveToIndex(int index){
        Node cur=head;
        if(index<numNodes && index>=0){
            for(int i=0; i<index;i++){
                cur=cur.next;
            }
            return (E) cur.data;
        }
        return null;
    }
    public E moveToTail(){
        Node cur= head;
        while (cur.next!=null){
            cur=cur.next;
        }
        return (E) cur.data;
    }
    // xoa dau
    public void removeFirst(){
        Node temp=head.next;
        head=temp;
        numNodes--;
    }
    //xoa cuoi
    public void removeLast(){
        Node temp= head;
        Node holder=null;
        while (temp.next!=null){
            holder=temp;
            temp=temp.next;
        }
        holder.next=null;
        numNodes--;
    }
    //xoa index
    public Object removeToIndex(int index){

        if(moveToIndex(index)==null)
            return false;
        if(index==0){
            removeFirst();
        }
        if (index==numNodes-1){
            removeLast();
        }
        if(index>0 && index<numNodes-1){
         Node temp= head;
         Node hordel=null;
         int count=0;
         while (temp.next!=null){
             hordel=temp;
             temp=temp.next;
             count++;
             if(count==index){
                 hordel.next=temp.next;
                 break;
             }
         }
        }
        return true;
    }
    // clear
    public void clear(){
        numNodes=0;
    }
    //kiem tra xem co chua trong linkedList hay ko
    public boolean contains(E e){
        Node tmp= head;
        while (tmp.next!=null){
            tmp=tmp.next;
            if(tmp.data.equals(e)){
                return true;
            }
        }
        return false;
    }
    //indexOf
    public int indexOf(E e){
        Node tmp=head;
       for (int i=0; i<numNodes;i++){
           if(tmp.data.equals(e)){
               return i;
           }
           tmp=tmp.next;
       }
       return -1;
    }
    //clone
    @Override
    public MyLinkedList clone(){
        Node cloneCur= head;
        MyLinkedList clone= new MyLinkedList(cloneCur.getData());
        for (int i = 1; i < numNodes; i++) {
            cloneCur = cloneCur.next;
            clone.addLast(cloneCur.getData());
        }
        return clone;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList  = new MyLinkedList<>(2);
        System.out.println(myLinkedList.size());
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(5);
        myLinkedList.addFirst(6);
        myLinkedList.print();
        System.out.println(myLinkedList.size());
        myLinkedList.addLast(7);
        myLinkedList.addLast(8);
        myLinkedList.print();
        System.out.println(myLinkedList.size());
        myLinkedList.addToIndex(2,12);
        myLinkedList.addToIndex(2,13);
        myLinkedList.print();
        System.out.println(myLinkedList.size());
        System.out.println("get first, last, index");
        System.out.println(myLinkedList.getFirst());
        System.out.println(myLinkedList.getLast());
        System.out.println(myLinkedList.get(0));
        System.out.println("xoa dau xoa cuoi xoa index");
        myLinkedList.removeFirst();
        myLinkedList.removeFirst();
        myLinkedList.removeFirst();
//        myLinkedList.removeLast();
//        myLinkedList.removeToIndex(5);
        myLinkedList.print();
//        myLinkedList.clear();
//        myLinkedList.print();
//        System.out.println(myLinkedList.size());
//        System.out.println(myLinkedList.contains(3));
//        System.out.println(myLinkedList.contains(333));
//        System.out.println(myLinkedList.indexOf(3));
//        System.out.println(myLinkedList.indexOf(333));
    }



}
