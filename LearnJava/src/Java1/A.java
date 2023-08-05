package Java1;
public class A{
    int id=1;
    String name="kii";

    void A(A ob){
        System.out.println("Vo kim thannh");
    }
    void B(){
        A(this);
    }
    void display() {
        System.out.println(id + " " + name);
    }

    public static void main(String args[]) {
        A s1 = new A();
        A s2 = new A();
        s2.B();
    }
}