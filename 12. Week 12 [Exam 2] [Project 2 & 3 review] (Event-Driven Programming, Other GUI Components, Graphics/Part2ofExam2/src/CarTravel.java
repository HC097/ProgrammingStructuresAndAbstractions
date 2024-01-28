import java.util.List;

public class CarTravel extends Travel implements TravelCost {

 private static final double CAR_TRAVEL_COST_MULTIPLIER = 100.0;

 public CarTravel() {
  super();
 }

 public CarTravel(List<String> inDestinations) throws EmptyDestinationException {
  super(inDestinations);
 }

 public Double calculateTripCost() {
  return calculateTripCost(getDestinations());
 } 
 
 @Override
 public Double calculateTripCost(List<String> inDestinations) {
  
  // Fill this in
  
 }
 
 /*
  * Cost = number of characters in the string (except the whitespace characters) times 100
  */
 public Double cost(String dest) {
  dest = dest.trim();
  dest = dest.replaceAll("\\s+", "");
  Double cost = dest.length() * CAR_TRAVEL_COST_MULTIPLIER;
  return cost;
 }

 @Override
 public String toString() {
  String msg = "\n** Car Travel **";
  return  msg + super.toString() + " Cost: $" + calculateTripCost() + " Time: " + calculateTripTime();
 }

 @Override
 public Double calculateTripTime() {
    
    
  // Fill this in
  
  
 }

}
