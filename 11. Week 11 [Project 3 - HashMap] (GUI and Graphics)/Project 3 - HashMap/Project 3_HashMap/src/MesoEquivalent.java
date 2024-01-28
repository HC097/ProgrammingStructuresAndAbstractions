/**
 * Methods to create a Hashmap of station IDs and their ASCII averages out of the data in the "Mesonet" text file.
 *
 * @author Harley Combest
 * @version 2020-11-04
 */
import java.util.*;
import java.io.*;
// TODO: Auto-generated Javadoc

/**
 * The Class MesoEquivalent.
 */
public class MesoEquivalent{

    /** The station ID. */
    private String stationID;

    /**
     * This method intitializes the MesoEquivalent object when it is created.
     *
     * @param stID      This is a String representation of a given station ID.
     * */
    public MesoEquivalent(String stID){
        this.stationID = stID;
    }

    /**
     * This method returns a HashMap representation of the station IDs given in the mentioned file
     * with station IDs as Strings  as keys and their ASCII averages as Integers as values.
     *
     * @return     HashMap<String, Integer> asciival2  with station ID's as String keys and
     *             their ASCII averages as Integer values.
     * */
    public HashMap<String, Integer> calAsciiEqual(){

        MesoAsciiCal asciiAverage2 = new MesoAsciiCal(new MesoStation(this.stationID));
        int avgSearchedFor = asciiAverage2.calAverage();
        String equalStations = "";

        HashMap<String, Integer> asciiVal2 = new HashMap<String, Integer>();
        try{
            Scanner input = new Scanner("Mesonet.txt");
            File file = new File(input.nextLine());
            input = new Scanner(file);
            String regex = "(\\s)+";

            while(input.hasNextLine()){

                String line = input.nextLine();

                if(line.startsWith("    1") || line.startsWith("\t2")
                        || line.startsWith("  S")){
                    continue;
                }

                String[] row = line.split(regex);
                String tempStr = (row[1]).replaceAll(" ", "" );

                //System.out.println(tempStr);
                MesoAsciiCal tempAvg = new MesoAsciiCal(new MesoStation(tempStr));
                Integer integerTempAvg = (Integer) tempAvg.calAverage();

                if(integerTempAvg ==  avgSearchedFor){
                    asciiVal2.put(tempStr, integerTempAvg);
                }

            }input.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return asciiVal2;
    }

}