public abstract class A {
     public A(){
         System.out.println("Hello World!");
     }

     public A(String toPrint){
         System.out.println(toPrint);
     }

     public void B(){
         System.out.println("Bye World!");
     }

     public abstract double C();

}