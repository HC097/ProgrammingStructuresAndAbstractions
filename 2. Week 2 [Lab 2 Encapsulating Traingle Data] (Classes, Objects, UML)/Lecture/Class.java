import java.util.*;
public class Class{
    public static void main(String[] args) throws InterruptedException{

        ArrayList<Student> myclass = new ArrayList<Student>();

        System.out.println(Student.getNumStudents());

        myclass.add(new Student("John", "abc001"));
        System.out.println(Student.getNumStudents());

        myclass.add(new Student("Alice", "abc002"));
        System.out.println(Student.getNumStudents());

        myclass.add(new Student("Emma", "abc003"));
        System.out.println(Student.getNumStudents());

        myclass.add(new Student("Adam", "abc004"));
        System.out.println(Student.getNumStudents());

        myclass.add(new Student("Batman", "abc005"));
        System.out.println(Student.getNumStudents());

        myclass.remove(0);
        System.gc(); //garbage collector doesn't get invoke right away, you may have issue.
        Thread.sleep(100); //Pauses execution by 100 for garbage collector
        System.out.println(Student.getNumStudents());

        myclass.add(new Student("John", "abc001"));
        System.out.println(Student.getNumStudents());

    }
}