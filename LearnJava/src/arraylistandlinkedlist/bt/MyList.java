package arraylistandlinkedlist.bt;

import java.util.Arrays;

public class MyList<E> {
    private int size;
    private final int DEFAULT_CAPACITY=10;
    private E elements[];
    public MyList(){
        elements=(E[]) new Object[DEFAULT_CAPACITY];
    }
    public MyList(int size){
        elements=(E[]) new Object[size];
    }
    public void  ensureCapa(){
        int newSize= elements.length*2;
        if(size>elements.length){
            elements= Arrays.copyOf(elements,newSize);
        }
    }
    // add to first
    public void addFirst(E e){
    size+=1;
    ensureCapa();
    elements[size-1]=e;
    }
    //add to index
    public boolean addToInDex(int index, E e){
        if(index>=0 && index<size){
            size++;
            ensureCapa();
            for(int i=size-1; i>=index;i--){
                elements[i+1]=elements[i];
            }
            elements[index]=e;
            return true;
        }
        return false;
    }
    //lay ra phan tu vi tri i
    public E get(int index){
        return elements[index];
    }
    // check Empty
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        else{
            return false;
        }
    }
    //Lay ra index cua phan tu
    public int indexOf(E e){
        for(int i=0; i<size;i++){
            if(elements[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    //xoa phan tu khi co index
    public boolean remove(int index){
        if(index>=0 && index<size){
            for(int i=index; i<size-1;i++){
                elements[i]=elements[i+1];
            }
            size--;
            return true;
        }
        return false;
    }
    // lay ra size
    public int size(){
        return size;
    }
    //in ra arraylist
    public void print(){
        if(isEmpty()){
            System.out.println("MyList is Empty");
        }else{
            for(int i=0; i<size;i++){
                System.out.print(elements[i]+" ");
            }
        }
        System.out.println();
    }
    // sao chep ra 1 arrayList moi
    public MyList clone(){
        MyList<E> clone= new MyList<>(elements.length);
        for(E x:elements){
            clone.addFirst(x);
        }
        return clone;
    }
    public boolean contains(E e){
        if(!isEmpty()){
            for(int i=0; i<size;i++){
                if(elements[i].equals(e)){
                    return true;
                }
            }
        }
        return false;
    }
    public void clear(){
        size=0;
        elements=(E[]) new Object[DEFAULT_CAPACITY];
    }
    public static void main(String[] args) {
        MyList<Integer> myList= new MyList<>();
      myList.addFirst(1);
      myList.addFirst(2);
      myList.addFirst(3);
        myList.print();
    }


}
