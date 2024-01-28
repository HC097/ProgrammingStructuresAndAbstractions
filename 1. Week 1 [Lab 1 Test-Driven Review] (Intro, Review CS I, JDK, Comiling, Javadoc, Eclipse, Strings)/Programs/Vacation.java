
import java.io.*; 

public class Vacation {
	public static void main(String[] args)  throws IOException  {
    	
        System.out.println("Enter is your favourite vacation place:");
    	
        //Enter data using BufferReader 
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in)); 
      
	    // Reading data using readLine 
	    String place = reader.readLine(); 
	
	    // Printing the read line 
	    System.out.println("You entered " + place + " as your favorite vacation place.");

    }
}
