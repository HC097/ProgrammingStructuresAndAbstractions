import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileTest{
    public static void main(String[] args){
        try{
            FileWriter myFile1 = new FileWriter("filename.txt");
            myFile1.write("Line 001\n");
            myFile1.write("Line 002\n");
            myFile1.close(); // always close your files MEMORY, LOOPs
            System.out.println("Successfully wrote to the file.");

        }catch(IOException e){
            System.out.println("An error occurred, ");
            e.printStackTrace();
        }

        try{
            File myFile2 = new File("filename.txt");
            Scanner myReader = new Scanner(myFile2);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();//Close the reader to the file
        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}