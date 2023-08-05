package linkerlist;

public class Node {
    int value;
    Node next;
    Node(int value){
        this.value= value;
    }
    // print linkedList
    public static void printLinkedList(Node head){
        if(head==null){
            System.out.println("LinkedList is empty");
        }else{
            Node tmp= head;
            while(tmp!=null){
                System.out.print(tmp.value);
                tmp=tmp.next;
                if(tmp!=null){
                    System.out.print("-->");
                }else{
                    System.out.println();
                }
            }
        }
    }
    // add elements to first linkedList
    public static Node addToHead(Node headNode,int value){
        Node newNode = new Node(value);
        if(headNode!=null){
            newNode.next=headNode;

        }
        return newNode ;
    }

    // add elements to last linkedList
    public static Node addToTail(Node headNode, int value){
        Node newNode= new Node(value);
        if(headNode==null){
            return newNode;
        }else{
            Node lastNode= headNode;
            while (lastNode.next!=null){
                lastNode=lastNode.next;
            }
            lastNode.next=newNode;
        }
        return headNode;
    }
    // add elements to index
    public static Node addToIndex(Node headNode, int value, int index){
        Node newNode= new Node(value);
        if(index==0){
           headNode= addToHead(headNode,value);
        }else{
            Node prevNode= headNode;
            int count=0;
            while(prevNode!=null){
                count++;
                if(count==index){
                    newNode.next=prevNode.next;
                    prevNode.next=newNode;
                    break;
                }
                prevNode=prevNode.next;
            }
        }
        return headNode;
    }

    //remove elements to first LinkerList
    public static Node removeFirst(Node headNode){
        if(headNode!=null){
            return headNode.next;
        }
        return null;
    }
    //remove elements to tail LinkedList
    public static Node removeLast(Node headNode){
        if(headNode==null){
            return null;
        }
        Node lastNode=headNode;
        Node prevNode=null;
        // su dung ki thuat 2 con tro
        while (lastNode.next!=null){
            prevNode=lastNode;
            lastNode= lastNode.next;
        }
        if(prevNode==null){
            return null;
        }else{
            prevNode.next=lastNode.next;
        }
        return headNode;
    }
    //remove elements To index
    public static Node removeIndex(Node headNode, int index) {
        if (headNode == null || index < 0)
            return null;
        if (index == 0) {
            return removeFirst(headNode);
        }
            Node currNode = headNode;
            Node prevNode = null;
            int count = 0;
            boolean bisFound = false;
            while (currNode != null) {
                if (count == index) {
                    //remove curNode
                    bisFound = true;
                    break;
                }
                prevNode = currNode;
                currNode = currNode.next;
                count++;
            }
            //remove cur
            if(bisFound){
                if(prevNode==null){
                    //cur Node is last node
                    return  null;
                }else{
                    if(currNode!= null){
                        prevNode.next=currNode.next;
                    }
                }
            }
        return headNode;
        }

    }



