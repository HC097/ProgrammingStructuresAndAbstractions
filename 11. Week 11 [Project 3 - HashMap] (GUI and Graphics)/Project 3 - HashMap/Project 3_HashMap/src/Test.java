import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.*;
// TODO: Auto-generated Javadoc

/**
 * The Class Test.
 */
public class Test{

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args){

        //Section 1

        DateTimeThree dateTimeThree = new DateTimeThree();
        dateTimeThree.compareYear();
        System.out.println("\nInitial Hashmap:");
        dateTimeThree.dateHashMap();
        System.out.println("\nNow the sorted Hashmap:");
        dateTimeThree.dateHashMapSorted();
        System.out.println("\n");

        //Section 2
        String stId = "OKCE";
        MesoAsciiCal asciiAverage = new MesoAsciiCal(new MesoStation(stId));
        int asciiAvg = asciiAverage.calAverage();
        HashMap<String, Integer> asciiVal = new HashMap<String, Integer>();
        asciiVal.put(stId, asciiAvg);
        System.out.print("ASCII average: ");
        System.out.println(asciiVal.get(stId));
        MesoEquivalent mesoEqual = new MesoEquivalent(stId);
        System.out.println("Stations are: "+ mesoEqual.calAsciiEqual());
        System.out.println("\nUnsroted Hashmap:");
        asciiVal=mesoEqual.calAsciiEqual();
        for (String stIds : asciiVal.keySet()) {
            //Printing the unsorted map
            System.out.println(stIds + " " + asciiVal.get(stIds));
        }
        System.out.println("\nThe sorted map:");
        new MesoLexicographical(asciiVal);

        //Section 3
        System.out.println("\nThe dates in HashMap are sorted using algorithm:\n");
        DateSortingUsingAlgorithm dateSortingUsingAlgorithm = new DateSortingUsingAlgorithm();
        System.out.println("Sorting of the dates in descending order:");
        long startTime = System.nanoTime();
        dateSortingUsingAlgorithm.dateHashMapSortedDescending();
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Sorting of the dates in ascending order:");
        long startTime2 = System.nanoTime();
        dateSortingUsingAlgorithm.dateHashMapSorted();
        long estimatedTime2 = System.nanoTime() - startTime2;
        System.out.println("\nExecution time for the case 1: " + estimatedTime);
        System.out.println("Execution time for the case 2: " + estimatedTime2);
    }

}