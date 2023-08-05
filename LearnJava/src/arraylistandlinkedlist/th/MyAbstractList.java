package arraylistandlinkedlist.th;

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size= 0;
    protected MyAbstractList(){

    }
    protected MyAbstractList(E[] obj){
        for(int i=0;i<obj.length;i++)
            add(obj[i]);
    }

    @Override
    public void add(E e) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E remove(E e) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
