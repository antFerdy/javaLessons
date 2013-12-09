import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;


public class JukeBox1 {
	ArrayList<Song> songList = new ArrayList<Song>();
	
	public static void main(String[] args) {
		new JukeBox1().go();

	}

	public void go() {
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
		
		/*ArtistCompare sorting = new ArtistCompare();
		Collections.sort(songList,sorting);
		System.out.println(songList);*/
		
		/*HashSet<Song> songSet = new HashSet<Song>();
		songSet.addAll(songList);
		System.out.println(songSet);*/
		
		/*SongComparator sCompare = new SongComparator();
		TreeSet<Song> songSet = new TreeSet<Song>(sCompare);
		songSet.addAll(songList);
		System.out.println(songSet);*/
	}
	
	class ArtistCompare implements Comparator<Song> {
		public int compare(Song one, Song two) {
			return one.getArtist().compareTo(two.getArtist());
		}
		
	}
	
	
	

	private void getSongs() {
		try {
		File file = new File("C:\\SongList.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while((line=reader.readLine()) != null) {
				addSong(line);
			}	
		}
		catch(Exception e ){
			System.out.println("Something wrong!");
		}
	}

	private void addSong(String lineToParse) {
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0],tokens[1],tokens[2],tokens[3]);
		songList.add(nextSong);
	}
	
}
