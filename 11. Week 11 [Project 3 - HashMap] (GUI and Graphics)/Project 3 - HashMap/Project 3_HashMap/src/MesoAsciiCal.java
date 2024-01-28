// TODO: Auto-generated Javadoc
/**
 * Methods to get the ASCII average of various characters out of the data in the "Mesonet" text file.
 *
 * @author Harley Combest
 * @version 2020-11-04
 */
public class MesoAsciiCal extends MesoAsciiAbstract {

    /** The station ID. */
    private MesoStation stationID;

    /**
     * This method initializes the MesoAsciiCal object when it is created.
     * 
     * @param stID     Mesostation station ID
     * */
    public MesoAsciiCal(MesoStation stID){
       this.stationID = stID;
    }

    /**
     * This method calculates the ASCII average mentioned by taking the adding the ASCII values
     * of characters from given strings in and dividing their total by the total number of
     * characters, taking that quotient and getting its floor and ceiling values, using those
     * values by determining that if the praction part of the mentioned quotient has a fractional
     * part less than .25 the First Average will be expressed as its floor value and as its
     * ceiling value otherwise, setting a Second Average at 78, and, finally, getting the Final
     * Average by getting the average of the First and Second Average before determing whether or
     * not this Final Average be expressed as its floor or ceiling value (it will be ceiling if it
     * as any fraction above or below a whole number).
     *
     * @return the int
     */
    public int calAverage(){
        String speciStation = this.stationID.getStID();
        char[] chars= speciStation.toCharArray();

        double totalValue = 0;
        double initialAvg = 0;

        double ceilingVal = 0;
        double floorVal = 0;
        double intermediateAvg = 0;

        double arbitraryFixedAvg = 78;
        double finalAvg = 0;

        for(int i = 0; i < chars.length; i++){
            totalValue = totalValue + ( (double) chars[i]);
        }

        initialAvg = totalValue / (chars.length);

        ceilingVal = Math.ceil(initialAvg);
        floorVal = Math.floor(initialAvg);

        if(initialAvg - floorVal < .25){
            intermediateAvg = floorVal;
        }else{
            intermediateAvg = ceilingVal;
        }

        finalAvg = (intermediateAvg + arbitraryFixedAvg) / 2;

        if(finalAvg - Math.floor(finalAvg) > 0.00){
            finalAvg = Math.ceil(finalAvg);
        }

        return (int) finalAvg;
    }
}