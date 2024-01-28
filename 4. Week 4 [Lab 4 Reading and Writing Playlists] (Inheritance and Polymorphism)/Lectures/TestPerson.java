public class TestPerson{

    public statice void main(String[] args){
        Person person = new Person(1234L);
        long salary = person.getSalary();

        System.out.println(salary);
    }
}