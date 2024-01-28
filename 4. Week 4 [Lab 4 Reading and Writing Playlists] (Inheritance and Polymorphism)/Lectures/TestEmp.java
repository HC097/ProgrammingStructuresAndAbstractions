import java.util.ArrayList;

public class TestPerson{

    public static void main(String[] args) throws InterruptionException{
        ArrayList<Job> myemployees = new ArrayList<List>();

        // Upcasting Example
        myemployees.add(new Person(1111L));
        myemployees.add(new Dog(2222L));

        for(int i = 0; i < myemployee){
            System.out.println(myemployees.get(i).getSalary());
        }

        //Downcasting Example
        Job ifDog = new Dog(3333L);
        //ifDog.bark(); // Not Allowed
        if(ifDog instanceof Dog){
            Dog dog = (Dog) ifDog;
            dog.bark();
        }
    }
}