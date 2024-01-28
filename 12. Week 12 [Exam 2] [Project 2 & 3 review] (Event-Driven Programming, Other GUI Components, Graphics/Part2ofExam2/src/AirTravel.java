import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/** 
*   NOTE:
*	Air travel can only visit the place once, even if it is
*	repeated a few times
*/
public class AirTravel extends Travel implements TravelCost {

	public AirTravel() {
		super();
	}

	public AirTravel(List<String> inDestinations) throws EmptyDestinationException {
		// Look at the NOTE
		
		setDestinations(inDestinations);
	}
	
	@Override
	public void setDestinations(List<String> inDestinations) throws EmptyDestinationException {
		if (inDestinations == null) {
			throw new EmptyDestinationException("The list cannot be empty!");
		}
		
		// Fill this in (1)
		super.setDestinations(inDestinations);
		
		
	}

	@Override
	public Double calculateTripCost(List<String> inDestinations) {
		//
		// cost is 100 times bigger than the length of the destination string
		//
		
		// Fill this in (2)
		Double cost = 10 * calculateTripTime(inDestinations);
		
		return cost;
		
		
	}

	public Double calculateTripCost() {

		return calculateTripCost(super.destinations);
	}

	public Double calculateTripTime(List<String> inDestinations) {
	   
	   // Fill this in (3) X
	   Double time = inDestinations.size() * 2.0;
      System.out.println(time);
      return time;
	}

	@Override
	public Double calculateTripTime() {
		return calculateTripTime(getDestinations());
	}
	
	@Override
	public String toString() {
		String msg = "\n** Air Travel **";
		return  msg + super.toString() + " Cost: $" + calculateTripCost() + " Time:" + calculateTripTime();
	}

}