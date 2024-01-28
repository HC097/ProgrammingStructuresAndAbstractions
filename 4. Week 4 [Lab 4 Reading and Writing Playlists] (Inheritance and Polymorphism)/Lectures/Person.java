public class Person extends Job{

    /*/has-a relationship
    private Job job;

    public Person(long newSalary){
        this.job = new Job();
        job.setSalary(newSalary);
    }

    public long getSalary(){
        return job.getSalary();
    }
    */

    //Constructor
     public Person(long newSalary){
          super();
          super.setSalary(newSalary);
     }

     public long getSalary(){
          System.out.println("Person just did a method overriding;");
          retuen super.getSalary();
     }

     public Person(long newSalary){
          super.setSalary(newSalary);
     }

     public static int getNumEmp(){
          return numberofemp;
     }

     public void finalize(){
          numberofemp--;
     }

}
