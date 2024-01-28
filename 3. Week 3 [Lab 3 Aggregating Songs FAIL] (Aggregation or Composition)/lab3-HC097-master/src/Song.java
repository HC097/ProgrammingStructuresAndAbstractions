import java.util.Arrays;

//aggregation: when one object has a bunch of another object
public class Song { 
	
	//fields
	private String title;//String is automatically immutable 
	private String artist;//it automatically replaces it's values
	private int[] time;//once rewritten
	
	//overloaded constructor
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist = artist;
		//copyOf makes a copy of the time array and keeps the reference
		//being used to change the elements without a setter, making it
		//immutable
		int[] copy = Arrays.copyOf(time, time.length);
		this.time = copy;//setting it directly to the parameter allows it
						 //to be mutable. They'd have direct access to time.
	}
	
	//Getters
	public String getTitle() {
		return this.title;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	//copyOf makes a copy of the time array and keeps the reference
	//being used to change the elements without a setter, making it
	//immutable.
	public int[]  getTime() {
		int[] copy = Arrays.copyOf(time, time.length);
		return copy;
	}

}