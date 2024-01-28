import java.util.Arrays;

public class Playlist {//data structures: logic that runs the arrayList class.
//make "over sized" array.
	
		//fields
		private Song[] songs;
		private int numSongs;
		private final int MIN_CAPACITY = 2;
		
		//Constructor
		public Playlist() {
			Song[] copy = Arrays.copyOf(songs, MIN_CAPACITY);
			this.songs = copy;
			int counter = 0;
			for(int i = 0; i < songs.length; i++) {
				if (songs[i] != null) {
					counter++;
				}
			}
			this.numSongs = counter;
		}
		
		//Getters
		public int getCapacity() {
			return this.songs.length;
			
		}
		
		public int getNumSongs() {
			return this.numSongs;
		}
		
		/*Returns the Song w/ the given index in songs.
		If the given value is less than 0 or greater 
		than the index of the last Song, it returns null.*/
		public Song getSong(int index) {//songs.length?
			
				if(index < 0) {
					return null;
				}else if (index > index - 1) {
					return null;
				}else {
					return songs[index];
				}
				
		}
		
		//Setters
		public void addSong(Song song) {
			
			
		}
		
		public void addSong(int index, Song song) {
			
	
		}
		
		public Song removeSong() {
			
			return //a Song; 
		}
		
		public Song removeSong(int index) {
			
			return //a Song;
		}
}