import java.util.*;
public class Student{

    private String name;//private = restricted access
    private String id;
    private static int NumStudents = 0; //Since the NumStudents variable is STATIC that single variable is shared between ALL class objects, each object of that class does not have it’s own NumStudents variable.


    //Getters
    public String getName(){
        return name;
    }

    public String getAge(){
        return id;
    }

    public static int getNumStudents(){
        return NumStudents;
    }

    //Constructor
    public Student(String newName, String newId){
        this.id = newId;
        this.name = newName; //how does the constructo which newName to intializes
        NumStudents++;       // or work on across classes~ refer to current object.
                              //how the stack works.
    }                        //this is a reference that refers to

    /*
    * this is useful if you have variables of the same name.
    * for example if you have a public int named x and then you make
    * a constructor that gets passed a different int also named x,
    * you would use this to differentiate between the 2 - Michael Yu*/

    //finalize garbage collector does it in java, c++ has to be explicitly
    public void finalize(){
        NumStudents--;
    }
}