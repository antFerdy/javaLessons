import java.util.Comparator;


public class SongComparator implements Comparator<Song> {


	public int compare(Song a, Song b) {
		return(a.title.compareTo(b.title));
	}
	
}
