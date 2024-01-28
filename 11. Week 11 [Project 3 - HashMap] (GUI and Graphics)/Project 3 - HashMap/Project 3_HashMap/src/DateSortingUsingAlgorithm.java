/**
 * Methods to algorithmically sort data given in the "SortingDates" text file.
 *
 * @author Harley Combest
 * @version 2020-11-04
 */
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class DateSortingUsingAlgorithm.
 */
public class DateSortingUsingAlgorithm{

    /** The alg srtd. */
    protected HashMap<LocalDate, Integer> algSrtd;

    /**
     * This method initializes the DateSortingUsingAlgorithm object when it is created.
     */
    public DateSortingUsingAlgorithm(){

        this.algSrtd = new HashMap<LocalDate, Integer>();
        try{
            Scanner input = new Scanner("SortingDates.txt");
            File file = new File(input.nextLine());
            input = new Scanner(file);
                //2020-12-31
            int i = 0;
            while(input.hasNextLine()){
                String tempStr = input.nextLine().replaceAll("(\\s)+", "");
                //System.out.println(tempStr);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate tempDate = LocalDate.parse(tempStr, formatter);

                this.algSrtd.put(tempDate, i);

            }input.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    /**This method organizes the dates, of the data mentioned, in descending order and prints them as such.*/
    public void dateHashMapSortedDescending(){

        TreeMap<LocalDate, Integer> sortedDescending = new TreeMap<LocalDate, Integer>(Collections.reverseOrder());
        sortedDescending.putAll(this.algSrtd);

        for(Map.Entry<LocalDate,Integer> entry : sortedDescending.entrySet()) {
            LocalDate key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key);
        }

    }

    /**This method organizes the dates in ascending order and prints them as such.*/
    public void dateHashMapSorted(){

        TreeMap<LocalDate, Integer> sortedAscending = new TreeMap<LocalDate, Integer>();
        sortedAscending.putAll(this.algSrtd);

        for(Map.Entry<LocalDate,Integer> entry : sortedAscending.entrySet()) {
            LocalDate key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key);
        }

    }

    /***/
}