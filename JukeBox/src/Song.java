
public class Song implements Comparable<Song>{
	String title;
	String artist;
	String rating;
	String bmp;
	
	Song(String t, String a, String r, String b) {
		title = t;
		artist = a;
		rating = r;
		bmp = b;
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() { 
		return artist;
	}
	
	public String getRating() {
		return rating; 
	}
	
	public String getBmp() {
		return bmp; 
	}
	
	public String toString() {
		return title;
	}


	public int compareTo(Song s) {
		return title.compareTo(getTitle());
	}
	
	public boolean equals (Object aSong) {
		Song s = (Song)aSong;
		return getTitle().equals(s.getTitle());
	}
	
	public int hashCode() {
		return title.hashCode();
	}
 	
	
}
