package abstractandinterface;

abstract class Shape {
    abstract void draw();
}
class Rectangle extends Shape{
    @Override
    void  draw(){
        System.out.println("Ve hinh chu nhat");
    }
}
class Circle extends Shape{
    @Override
    void draw() {
        System.out.println("ve hinh tron");
    }   
}class KiemTra{
    public static void main(String[] args) {
        Shape rc= new Rectangle();
        rc.draw();
        Shape ht= new Circle();
        ht.draw();
    }
}
