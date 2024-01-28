import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTravelTest {
    private static final double MATCH_LIMIT = 0.0001;
    CarTravel travel;
    List<String> destinations;

    @BeforeEach
    void setUp() throws Exception {
        String[] places = {"Boston", "Tulsa", "Houston", "Toledo"};
        destinations = new LinkedList<>(Arrays.asList(places));
        travel = new CarTravel(destinations);
    }

    @Test
    void testCalculateTripTime() {
        Double travelTIme = travel.calculateTripTime();
        Double expectedTime = 80.0;

        assertEquals(expectedTime, travelTIme, MATCH_LIMIT);

        List<String> newDestinations = new LinkedList<>(destinations);
        newDestinations.add("Norman");
        expectedTime =  Double.valueOf(100.0);

        try {
            travel.setDestinations(newDestinations);
        } catch (EmptyDestinationException e) {
            e.printStackTrace();
            fail();
        }

        travelTIme = travel.calculateTripTime();
        assertEquals(expectedTime, travelTIme, MATCH_LIMIT);
    }

    @Test
    void testToString() {
        String expected = "\n** Car Travel ** { destinations:'[Boston, Tulsa, Houston, Toledo]'} Cost: $2400.0 Time: 80.0";
        String actual = travel.toString();
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    void testCarTravel() {
        // Test both constructors
        CarTravel at = new CarTravel();
        List<String> list = at.getDestinations();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("A", "AB", "ABC"));
        assertTrue(expected.equals(list));

    }

    @Test
    void testCarTravelListOfString() {
        CarTravel at = new CarTravel();
        List<String> list = at.getDestinations();

        ArrayList<String> expected = new ArrayList<>(Arrays.asList("A", "AB", "ABC"));
        boolean result = true;
        int index = 0;
        for(String str: list) {
            if (str.equals(expected.get(index++))) {
                result = true;
            }
            if (result == false)
                break;
        }
        assertTrue(result);
    }

    @Test
    void testCalculateTripCostListOfString() {
        String[] places = {"Oklahoma City", "Tulsa", "Houston", "Toledo", "Manchester City"};
        List<String> list = new LinkedList<>(Arrays.asList(places));
        Double actual = travel.calculateTripCost(list);
        Double expected = 4400.0;
        assertEquals(expected, actual, MATCH_LIMIT);
    }

    @Test
    void testCalculateTripCost() {
        Double expected = Double.valueOf(2400.0);
        Double actual = travel.calculateTripCost();
        assertEquals(expected, actual, MATCH_LIMIT);
    }

    @Test
    void testGetDestinations() {
        String[] places = {"Oklahoma City", "Tulsa", "Houston", "Toledo", "Manchester City"};
        List<String> list = new LinkedList<>(Arrays.asList(places));
        CarTravel at = new CarTravel();
        try {
            at.setDestinations(list);
            Double actual = travel.calculateTripCost(list);
            Double expected = 4400.0;
            assertEquals(expected, actual, MATCH_LIMIT);
        } catch (EmptyDestinationException e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    void testEqualsObject() {
        CarTravel from = new CarTravel();
        CarTravel to = new CarTravel();
        ArrayList<String> x = new ArrayList<>();
        x.add("what");
        x.add("why");
        x.add("no");
        try {
            to.setDestinations(x);
        } catch (EmptyDestinationException e) {

            e.printStackTrace();
        }
        assertFalse(from.equals(to));

        assertFalse(from.equals(to));



        assertFalse(from.equals(travel));
    }


}