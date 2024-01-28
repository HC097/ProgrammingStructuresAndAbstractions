/**
 * Methods to sort data from "Dates" text file through HashMaps.
 *
 * @author Harley Combest
 * @version 2020-11-04
 */
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
// TODO: Auto-generated Javadoc

/**
 * The Class DateTimeThree.
 */
public class DateTimeThree{

    /** The date integer hash map. */
    protected HashMap<LocalDate, Integer> dateIntegerHashMap;

    /**
     * This method initilaizes the DateTimeThree object when it is created.
     * */
    public DateTimeThree(){
        this.dateIntegerHashMap = new HashMap<LocalDate, Integer>();
    }

    /**
     * This method compares the dates given: it determines which belong to leap years and which do not, and it
     * finds the difference between the mentioned dates and our current time.
     */
    public void compareYear(){

        try{
            Scanner input = new Scanner("Dates.txt");
            File file = new File(input.nextLine());
            input = new Scanner(file);

            int i = 0;
            while(input.hasNextLine()){

                i++;

                //Reading in input to String
                String date = input.nextLine();

                //Conversion of String to LocalDate and placing both that and
                //Integer into HashMap
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.d.yyyy");
                LocalDate localDate = LocalDate.parse(date, formatter);
                dateIntegerHashMap.put( localDate, (Integer) i);

                //Converting whole date String into int Year
                String yearAsStr = date.substring(6, 10);
                int year =  Integer.parseInt(yearAsStr);
                boolean isLeap = false;

                //Determined results after leap year if-statement
                String yesLeap = " is a leap year";
                String noLeap = " is not a leap year";

                //Difference in between current time and date mentioned & String result
                LocalDate currentTime = LocalDate.now();
                Period period = Period.between(localDate, currentTime);

                String differenceInTime = ", and Difference: " +
                        Integer.toString(period.getYears()) + " years, " +
                        Integer.toString(period.getMonths()) + " months, "
                        + Integer.toString(period.getDays()) + " days.";

                //Is the year a leap year?
                if(year % 4 == 0)
                {
                    if( year % 100 == 0)
                    {
                        if ( year % 400 == 0)
                            isLeap = true;
                        else
                            isLeap = false;
                    }
                    else
                        isLeap = true;
                }
                else {
                    isLeap = false;
                }

                //Result depending on if it is or isn't
                if(isLeap == true) {
                    System.out.println(year + yesLeap + differenceInTime);
                }else {
                    System.out.println(year + noLeap + differenceInTime);
                }

            }
            input.close();

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method breaks the data of dates into a HashMap.
     * */
    public void dateHashMap(){
        Set<LocalDate> setOfKeys = dateIntegerHashMap.keySet();
        LocalDate[] keys = setOfKeys.toArray(new LocalDate[setOfKeys.size()]);

        Collection<Integer> setOfValues = dateIntegerHashMap.values();
        Integer[] values = setOfValues.toArray(new Integer[setOfValues.size()]);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("YYYY-MM-dd");

        for(int i = 0; i < dateIntegerHashMap.size(); i++) {

            int year;
            //format for 20th century
            if( (formatter2.format(keys[i])).contains("1901") ){
                System.out.println( (formatter2.format(keys[i])).replace("1901", "1900")
                        + ":" + values[i]);
            }else{
                System.out.println(formatter2.format(keys[i]) + ":" + values[i]);
            }

        }
    }

    /**
     * This method sorts the dates already put together in a HashMap by time (older to newer) using TreeMap.
     * */
    public void dateHashMapSorted(){
        //Sorting by key through TreeMap because TreeMap auto-sorts and for-loop
        //that goes by entry.

        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("YYYY-MM-dd");

        TreeMap<LocalDate, Integer> sorted = new TreeMap<>();
        sorted.putAll(dateIntegerHashMap);

        for(HashMap.Entry<LocalDate, Integer> entry : sorted.entrySet()) {

            //format for 20th century
            if( (formatter3.format(entry.getKey())).contains("1901") ){
                System.out.println( (formatter3.format(entry.getKey())).replace("1901", "1900")
                        + ":" + entry.getValue());
            }else{
                System.out.println(formatter3.format(entry.getKey()) + ":" + entry.getValue());
            }

        }
    }


}