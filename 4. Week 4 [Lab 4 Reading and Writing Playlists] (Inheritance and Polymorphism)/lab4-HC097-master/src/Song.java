import java.util.Arrays;
/*
 * used: s.replaceFirst("^0+(?!$)", ""): regex tool replaceFirst() method
 * 
 * */
public class Song {
	
	private String title;
	private String artist;
	private int[] time;
	//title, artist, and time delimiter
	private final String INFO_DELIMITER = "; ";
	//time minutes seconds delimiter
	private final String TIME_DELIMITER = ":";
	//Indices of Info
	private final int IDX_TITLE = 0;
	private final int IDX_ARTIST = 1;
	private final int IDX_TIME = 2;
	
	
	
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist = artist;
		this.time = Arrays.copyOf(time, time.length);
		
	}
	
	/*This method initializes a Song by parsing a String that
	 * contains the title, artist, and time with a semicolon
	 * and a space used as the delimiter. It then separates
	 * the parts of time with a delimiter before returning
	 * a full int[] of the parts all while removing and padding
	 * zeroes when necessary.*/
	public Song(String info) {
		
		//local string time variable
		String timeyWimey = "";
		
		//local int[] time variable with indice for 3 parts of time
		int[] timeTemp = new int[3];
		
		//The parts of time split by the delimiter
		String hours = "";
		String minutes = "";
		String seconds = "";
		
		//if-statement that breaks up info into separate parts
		if(info.contains(INFO_DELIMITER) ) {
			String parts[] = info.split(INFO_DELIMITER);
			this.title = parts[IDX_TITLE];
			this.artist = parts[IDX_ARTIST];
			timeyWimey = parts[IDX_TIME];
		}else {
			System.out.println(info);
			System.out.println("Error: Did not include delimiter ';'. Are you a communist?!");
		}
		
		//if-statement that breaks time into separate parts
		if(timeyWimey.contains(TIME_DELIMITER)) {
			
			String parts[] = timeyWimey.split(TIME_DELIMITER);
			if(parts.length == 3) {
				hours = parts[0].replaceFirst("^0+(?!$)", "");
				//System.out.println("hours: " + hours);
				minutes = parts[1].replaceFirst("^0+(?!$)", "");
				//System.out.println("minutes: " + minutes);
				seconds = parts[2].replaceFirst("^0+(?!$)", "");
				//System.out.println("seconds: " + seconds);
				
			}else if(parts.length == 2 ) {
				minutes = parts[0].replaceFirst("^0+(?!$)", "");
				//System.out.println("minutes: "  + minutes);
				seconds = parts[1].replaceFirst("^0+(?!$)", "");
				//System.out.println("seconds: " + seconds);
				
			}else if(parts.length == 1) {
				seconds = parts[0].replaceFirst("^0+(?!$)", "");
				//System.out.println("seconds: " + seconds);
				
			}else {
				System.out.println("Error: time is out of bounds. Try not being a communist next time!");
			}
			
		}else {
			
			String parts[] = timeyWimey.split(TIME_DELIMITER);
			seconds = parts[0].replaceFirst("^0+(?!$)", "");
			
			//System.out.println(timeyWimey);
			//System.out.println("Time does not contain delimiter ':'.");
		}
		
		//Transfer of Strings to int[]
		if(seconds.equals(null) || seconds.equals("")) {

			System.out.println("Error: there's no time. commie!");
			
		}else if(minutes.equals(null) || minutes.equals("")) {
			
			timeTemp[0] = Integer.parseInt(seconds.replaceFirst("^0+(?!$)", ""));
			//System.out.println("minutes null");
			this.time = Arrays.copyOf(timeTemp, timeTemp.length - 2);
			
			//System.out.println("seconds: " + timeTemp[0]);
			
		}else if(hours.equals(null) || hours.equals("")) {
			
			timeTemp[1] = Integer.parseInt(minutes.replaceFirst("^0+(?!$)", ""));
			timeTemp[0] = Integer.parseInt(seconds.replaceFirst("^0+(?!$)", ""));
			
			//System.out.println("hours null");
			this.time = Arrays.copyOf(timeTemp, timeTemp.length - 1 );
				
			
		}else {
			
			timeTemp[2] = Integer.parseInt(hours.replaceFirst("^0+(?!$)", ""));
			timeTemp[1] = Integer.parseInt(minutes.replaceFirst("^0+(?!$)", ""));
			timeTemp[0] = Integer.parseInt(seconds.replaceFirst("^0+(?!$)", ""));
			//System.out.println("nothing null");
			this.time = Arrays.copyOf(timeTemp, timeTemp.length);
			
		}
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int[] getTime() {
		return Arrays.copyOf(time, time.length);
	}
	
	
	/*This method returns a String representation of the Song
	 * in the same format as the info String parse by the new
	 * constructor.*/
	@Override
	public String toString() {
		String timeRep = "";
		//String hours = "";
		//String minutes = "";
		//String seconds = "";
		
		if(this.time.length > 0) {
			for(int i = 0; i < this.time.length; i++) {
				if(this.time.length == 1) {
					timeRep = String.format("%02d", this.time[i]) + timeRep;
				}else if(this.time.length > 1) {
					timeRep = String.format("%02d", this.time[i]) + ":" + timeRep;
				}			
			}
		}
		
		//System.out.println(timeRep);
		timeRep = timeRep.replaceFirst("^0+(?!$)", "");
		//System.out.println(timeRep);
		
		if(timeRep.endsWith(":")) {
			timeRep = timeRep.substring(0, timeRep.length() - 1);
		}
		
		
		return (this.title + "; " + this.artist + "; " + timeRep );
	}
}
