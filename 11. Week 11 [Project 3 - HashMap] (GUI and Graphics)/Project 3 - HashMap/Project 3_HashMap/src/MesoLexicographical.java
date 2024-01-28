/**
 * Methods to create a alphabetically sorted Hashmap of station IDs and their ASCII averages out of the data in the "Mesonet" text file.
 *
 * @author Harley Combest
 * @version 2020-11-04
 */
import java.util.*;
// TODO: Auto-generated Javadoc

/**
 * The Class MesoLexicographical.
 */
public class MesoLexicographical extends MesoSortedAbstract {

    /** The fully sorted map. */
    private Map<String, Integer> fullySortedMap;

    /**
     * This method initializes the MesoLexicographical object when it is created.
     *
     * @param unsorted      This is a Hashmap which repsents the already mentioned categories
     *                      but is not sorted alphabetically.
     **/
    public MesoLexicographical(HashMap<String, Integer> unsorted){
        this.fullySortedMap = sortedMap(unsorted);
        for (String stIds : this.fullySortedMap.keySet()) {
            //Printing the unsorted map
            System.out.println(stIds + " " + this.fullySortedMap.get(stIds));
        }
    }

    /**
     * This method sorts the elements within an unsorted HasMap by the station IDs respresented as String
     * keys.
     *
     * @param unsorted      This is a Hashmap which repsents the already mentioned categories
     *                      but is not sorted alphabetically.
     *
     * @return sorted       This is a Map which is represents a sorted (in the way mentioned) version
     *                      of the HashMap mentioned.
     * */
    @Override
    public Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted){
        TreeMap<String, Integer> sorted = new TreeMap<>();
        sorted.putAll(unsorted);

        return sorted;
    }

}