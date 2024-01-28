public class Person{

    private String name;
    private int age;

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }


    //DIVIDE//


    public void setName(String newName){
        this.name = newName; //pointer to the current object
    }

    public void setAge(int newAge){
        this.age = newAge;
    }

    public void setNameAndAge(String newName, int newAge){
        this.age = newAge;
        this.name = newName;

    }
}