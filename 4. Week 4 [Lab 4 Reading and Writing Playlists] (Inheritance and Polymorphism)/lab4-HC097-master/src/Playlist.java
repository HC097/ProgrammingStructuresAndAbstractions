import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
//import of FileReader and ArrayList Classes
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class Playlist {
	
	private ArrayList<Song> songs;
	
	public Playlist() {
		songs = new ArrayList<Song>();
	}
	/*Constructor implemented by first using this to call the other 
	 * constructor and, then, calling addSongs(String filename) to read
	 * the file. */
	public Playlist(String filename) throws IOException {
		this();
		addSongs(filename);
	}
	
	/*This method reads a file of info Strings with
	 * the given name. For each line of the file, it
	 * creates a Song and adds it to the end of the
	 * Playlist.*/
	public void addSongs(String filename) throws IOException{
		
		FileReader in = new FileReader(filename);
		BufferedReader br = new BufferedReader(in);
		
		String line;
		while((line = br.readLine()) != null  ) {
			line = removeDarnZeros(line);
			this.songs.add(new Song(removeDarnZeros(line)));
		}     
		in.close();
		
	}
	
	/*This method eliminates superfluous zeros from strings with time representations in them up to the hours mark.*/
	public String removeDarnZeros(String str) {
		if(str.contains(":")) {
			String parts[] = str.split(":");
			if(parts.length == 2) {
				parts[1] = parts[1].replaceFirst("^0+(?!$)", "");
				str = parts[0] + ":" + parts[1];
				return str;
			}else if (parts.length == 1) {
				parts[2] = parts[2].replaceFirst("^0+(?!$)", "");
				str = parts[0] + ":" + parts[1] + ":" + parts[2];
				return str;
			}else { 
				return str;
			}
		}else {
			return str;
		}
				
		
	}
	
	/*This method returns the String representations of the Songs
	 * joined by newline characters "\n". It does not terminate
	 * the resulting String with a new line. It uses the newline
	 * character by aesthetics and not  by full mechanical function*/
	@Override
	public String toString() {
		
		String songRep = "";
		//String songParts[];

		if(this.songs.size() > 1) {

			for (int i = 0; i < this.songs.size(); i++) {
				if(i == 0) {
					songRep = removeDarnZeros(String.valueOf(songs.get(i)));
				}else {
				songRep = songRep + "\n" + removeDarnZeros(String.valueOf(songs.get(i)));
				}
			}
			
		}else if (this.songs.size() == 1){
			songRep = removeDarnZeros(String.valueOf(songs.get(0)));
		}else {
			return "";
		}
		
		//System.out.println(songRep);
		return songRep;
		
	}
	
	/*This method saves the output of toString to a file with the
	 * given test name. It overwrites the contents of the file if it
	 * already exists.*/
	public void saveSongs(String filename) {
		BufferedWriter bw = null;
		try {
			//System.out.println(toString());
			String mycontent = toString();
			
			//Specification of file name and path
			File file = new File(filename);
			
			//File will be created if it's not present at specific location
			if(!(file.exists())) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write(mycontent);;
			//System.out.println("File written Successfully");
			
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally {
			try {
				if(bw != null) {
					bw.close();
				}
			}catch(Exception ex) {
				System.out.println("Error in closing the BufferWriter" + ex);
			}
		}
	}
	
	/*This method gets the total time for each individual song entered*/
	public int specTime(String ofSong) {
		
		String wholeTwo;
		
		if(ofSong.trim().length() > 7) {
			ofSong.trim();
			wholeTwo = ofSong.replaceFirst("^9+(?!$)", "");
			ofSong = wholeTwo;
			//System.out.println("5. Beethoven split: " + wholeTwo);
		}else {
			wholeTwo = null;
		}
		
		if (ofSong.contains(";")) {
			String cutOne[] = ofSong.split(";");
			//System.out.println(cutOne[0]);
			//System.out.println(cutOne[1]);
			//System.out.println(cutOne[2]);
			
			wholeTwo = cutOne[2];
		}else {
			wholeTwo = ofSong;
		}
		
		String cutTwo[];
		int hours;
		int minutes;
		int seconds;
		int totalTime;
		
		if(wholeTwo.contains(":")) {
			cutTwo = wholeTwo.split(":");
			if(cutTwo.length == 2) {
				minutes = Integer.parseInt(cutTwo[0]);
				seconds = Integer.parseInt(cutTwo[1]);
				totalTime = (minutes * 60) + seconds;
			}else if(cutTwo.length == 3) {
				hours = Integer.parseInt(cutTwo[0]);
				//System.out.println("hours: " + hours);
				minutes = Integer.parseInt(cutTwo[1]);
				seconds = Integer.parseInt(cutTwo[2]);
				totalTime = (hours * 3600) + (minutes * 60) + seconds;
			}else {
				seconds = Integer.parseInt(cutTwo[0]);
				totalTime = seconds;
			}
		}else {
			seconds = Integer.parseInt(wholeTwo);
			totalTime = seconds;
		}
		
		//System.out.println("2. specTime:" + totalTime);
		return totalTime;
	}
	
	/*This method takes the total time of an individual song and returns it
	 * in the hours, minutes, seconds format.*/
	public String retForm(int aTime) {
		int hours;
		int minutes;
		int seconds;
		String totalTime;
		
		if(aTime > 3600) {
			hours = aTime / 3600;
			minutes = (aTime % 3600) / 60;
			seconds = (aTime % 3600)  % 60;
			if (minutes < 10 && seconds < 10){
				totalTime = hours + ":0" + minutes + ":0" + seconds;
			}else if(minutes > 10 && seconds < 10) {
				totalTime = hours + ":" + minutes + ":0" + seconds;
			}else if (minutes < 10 && seconds > 10) {
				totalTime = hours + ":0" + minutes + ":" + seconds;
			}else {
				totalTime = hours + ":" + minutes + ":" + seconds;
			}
			
			
		}else if(aTime > 60) {
			minutes = aTime / 60;
			seconds = aTime % 60;
			totalTime = minutes + ":" + seconds;
		}else {
			seconds = aTime;
			totalTime = Integer.toString(seconds);
		}
		
		//System.out.println("3. retForm: " + totalTime);
		return totalTime;
	}
	
	/*This method returns the longest song. It checks if the playlist is empty,
	 * returning null if it is. If there is a tie for the longest Song, then
	 * the tie is broken by returning the Song with the smallest index.*/
	public Song getLongestSong() {
		
		String ofPlaylist = toString();
		if(ofPlaylist.isEmpty()) {
			return null;
		}else {
			String longestTimed = "";	
			ArrayList<Integer> theNums = new ArrayList<Integer>();
			for(int i = 0; i < songs.size(); i++) {
				//System.out.println("0: " + songs.get(i).toString());
				//System.out.println("1: " +  (songs.get(i).toString()).replaceAll("[^\\d:, ^:]", "") );
				theNums.add(specTime(   (songs.get(i).toString()).replaceAll("[^\\d:]", "")   ));
				
				
				if( (songs.get(i).toString()).contains( retForm(Collections.max(theNums) ) ) ){
					longestTimed = songs.get(i).toString();
				}
			}
			
			
			//System.out.println("4. longestTimed: " + longestTimed);
			return new Song(longestTimed);
			
		}
	
		
	}
	
	/*This method returns the total time of all the Songs as an array of integers.
	 * It uses the same format as the time field in the Song class (eg: 
	 * {seconds, minutes, hours}).*/
	public int[] getTotalTime() {
		
		int[] totalTime;
		int litSec = 0;
		int aTime = 0;
		
		int hours = 0;
		int minutes = 0;
		int seconds = 0;
		
		for(int i = 0; i < songs.size(); i++) {
			//System.out.println("0: " + songs.get(i).toString());
			//System.out.println("1: " +  (songs.get(i).toString()).replaceAll("[^\\d:, ^:]", "") );
			litSec = specTime(   (songs.get(i).toString()).replaceAll("[^\\d:]", "")   ) + litSec;	
		}
		
		aTime = litSec;
		
		if(aTime > 3600) {
			hours = aTime / 3600;
			minutes = (aTime % 3600) / 60;
			seconds = (aTime % 3600)  % 60;
			
			totalTime = new int[3];
			totalTime[0] = seconds;
			totalTime[1] = minutes;
			totalTime[2] = hours;		
			
		}else if(aTime > 60) {
			minutes = aTime / 60;
			seconds = aTime % 60;
			
			totalTime = new int[2];
			totalTime[0] = seconds;
			totalTime[1] = minutes;
			
			
		}else {
			seconds = aTime;
			
			totalTime = new int[1];
			totalTime[0] = seconds;
				
		}
		
		
		
		
		return totalTime;
	}
	
	/*This method returns the artist of each song entered*/
	public String artistName(String aSong) {
		
		String anArtist = "";
		String[] titleParts;
		
		if( !(aSong.isEmpty())) {	
			if((aSong.contains(";"))) {
				titleParts = aSong.split(";");
				anArtist = titleParts[1];
			}else {
				anArtist = "J.S Bach";
			}
			
			return anArtist;
		}else {
			return null;
		}
		
	}
	
	/*This method returns the artist that appears most frequently. In the case in which
	 * none of them are (there is a tie) it returns the artist that appeared first. In the
	 * case in which the playlist is empty, it returns null */
	public String getFavoriteArtist() {
		
		String ofPlaylist = toString();
		
		
		String previous = null;
		int highScore = 0;
		int score = 1;
		String favArtist = "";
	
		ArrayList<String> theNames = new ArrayList<String>();
		
		
		if(ofPlaylist.isEmpty()) {
			favArtist =  null;
		}else {
			System.out.println("1");
			for(int i = 0; i < songs.size(); i++) {
				System.out.println("2");
				theNames.add( artistName(songs.get(i).toString()).trim() );
				score = Collections.frequency(theNames,theNames.get(i));
				
				if(score == highScore) {
					favArtist = theNames.get(0);
				}
				
				
				if( score > highScore  ){
					favArtist = theNames.get(i);
					highScore = score;
				}
					
				previous = theNames.get(i);
				System.out.println(favArtist);
			}
				
			
		}	
		
		return favArtist;		
	}
	
	public int getNumSongs() {
		return songs.size();
	}
	
	public Song getSong(int index) {
		if (index < 0 || index >= getNumSongs()) {
			return null;
		}
		return songs.get(index);
	}

	public void addSong(Song song) {
		addSong(getNumSongs(), song);
	}

	public void addSong(int index, Song song) {
		if (index < 0 || index > getNumSongs()) {
			return;
		}
		songs.add(index, song);
	}
	
	public Song removeSong() {
		return removeSong(getNumSongs() - 1);
	}
	
	public Song removeSong(int index) {
		if (index < 0 || index >= getNumSongs()) {
			return null;
		}
		return songs.remove(index);
	}
}
