public class GetSet{
    public static void main(String[] args){
        Person myObj = new Person(); //Person does not exist on stack

        //myObj.name ="John"; // error
        //System.out.println(myObj.name);// error

        myObj.setName("John");
        myObj.setAge(20);
        System.out.println(myObj.getName());
        System.out.println(myObj.getAge());
    }
}