import java.util.HashMap;


public class TestMap {
	static HashMap<String,Integer> map = new HashMap<String,Integer>();
	
	public static void main(String[] args) {
		map.put("Rustem",22);
		map.put("Aisik",22);
		map.put("Mom",55);
		
	System.out.println("Rustem's name is " + map.get("Rustem"));
	System.out.println(map);
	}

}
