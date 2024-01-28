import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AirTravelTest {
    private static final double MATCH_LIMIT = 0.0001;
    AirTravel travel;
    List<String> destinations;

    // This method is called before each and every test
        //
    @BeforeEach
    void setUp() throws Exception {
        String[] places = {"Boston", "Tulsa", "Houston", "Toledo"};
        destinations = new LinkedList<>(Arrays.asList(places));
        travel = new AirTravel(destinations);
    }

    @Test
    void testCalculateTripTime() {
        Double travelTIme = travel.calculateTripTime();
        Double expectedTime = 8.0;

        assertEquals(expectedTime, travelTIme, MATCH_LIMIT);

        List<String> newDestinations = new LinkedList<>(destinations);
        newDestinations.add("Norman");
        expectedTime =  Double.valueOf(10.0);

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
        String expected = "\n** Air Travel ** { destinations:'[Toledo, Boston, Tulsa, Houston]'} Cost: $2400.0 Time:8.0";
        String actual = travel.toString();
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    void testAirTravel() {
        // Test both constructors
        AirTravel at = new AirTravel();
        List<String> list = at.getDestinations();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("A", "AB", "ABC"));

        assertTrue(list.equals(expected));
    }

    @Test
    void testAirTravelListOfString() {
        AirTravel at = new AirTravel();
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
        Double expected = 4600.0;
        assertEquals(expected, actual, MATCH_LIMIT);
    }

    @Test
    void testCalculateTripCost() {
        Double expected = Double.valueOf(2400.0);
        Double actual = travel.calculateTripCost();
        assertEquals(expected, actual, MATCH_LIMIT);
    }

    @Test
    void testCalculateTripTimeListOfString() {
        String[] places = {"Oklahoma City", "Tulsa", "Houston", "Toledo", "Manchester City"};
        List<String> list = new LinkedList<>(Arrays.asList(places));
        Double actual = travel.calculateTripCost(list);
        Double expected = 4600.0;
        assertEquals(expected, actual, MATCH_LIMIT);
    }

    @Test
    void testGetDestinations() {
        String[] places = {"Oklahoma City", "Tulsa", "Houston", "Toledo", "Manchester City"};
        List<String> list = new LinkedList<>(Arrays.asList(places));
        AirTravel at = new AirTravel();
        try {
            at.setDestinations(list);
            Double actual = travel.calculateTripCost(list);
            Double expected = 4600.0;
            assertEquals(expected, actual, MATCH_LIMIT);
        } catch (EmptyDestinationException e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    void testEqualsObject() {
        AirTravel from = new AirTravel();
        AirTravel to = new AirTravel();

        assertTrue(from.equals(to));

        assertTrue(to.equals(from));

        assertFalse(from.equals(travel));
    }


}