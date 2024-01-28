import java.util.List;

@FunctionalInterface
public interface TravelCost {
   public Double calculateTripCost(List<String> inTravelsStops);
}
