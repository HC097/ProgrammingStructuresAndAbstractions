
public class StringTest
{
    public static void main(String[] args) {
        
        // Several ways to create a String        
        String str1 = "ABC123";
        
        String str2 = new String("ABC123");
        
        char[] a = {'A', 'B', 'C', '1', '2', '3'};        
        String str3 = new String(a);
        
        /*
        if (str1.equals(str3)) {
            System.out.println("They are the same!");
            
        }*/
        
        
        System.out.println(str1.substring(0, 4));
        
    }
}
