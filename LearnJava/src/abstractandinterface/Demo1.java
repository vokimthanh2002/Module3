package abstractandinterface;

abstract class Demo1 {
     abstract  void run();
     static class HonDa extends Demo1{
         @Override
         void run(){
             System.out.println("un un un");
         }

         public static void main(String[] args) {
             Demo1 obj= new HonDa();
             obj.run();
         }
     }

    }

