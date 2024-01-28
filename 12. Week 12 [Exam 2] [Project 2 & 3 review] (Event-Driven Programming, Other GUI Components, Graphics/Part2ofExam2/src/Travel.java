package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Travel {
	protected List<String> destinations;

	protected Travel() {
		try {
			setDestinations(createDefaultDestinations());
		} catch (EmptyDestinationException e) {
			e.printStackTrace();
			System.out.println("This list should not be empty");
		}
	}

	protected Travel(List<String> destinations) throws EmptyDestinationException {
		if (destinations == null)
			throw new EmptyDestinationException("The destination list cannot be empty!");
		setDestinations(destinations);
	}

	public abstract Double calculateTripTime();

	private List<String> createDefaultDestinations() {

		List<String> defaultDestinations = new ArrayList<>();
		
		// Fill this in (6)
		return defaultDestinations;
		
	}

	public void setDestinations(List<String> inDestinations) throws EmptyDestinationException {
		if (inDestinations == null)
			throw new EmptyDestinationException("The list cannot be empty!");
		destinations = inDestinations;
	}

	public List<String> getDestinations() {
		return this.destinations;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Travel)) {
			return false;
		}
		Travel travel = (Travel) o;
		return destinations.equals(travel.destinations);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(destinations);
	}

	@Override
	public String toString() {
		return " {" + " destinations:'" + getDestinations() + "'" + "}";
	}

}
