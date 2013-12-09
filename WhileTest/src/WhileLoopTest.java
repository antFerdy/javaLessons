
public class WhileLoopTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] friends = new String[20];
		friends [0] = "Masha";
		friends [1] = "Matilda";
		friends [2] = "Rosa";
		friends [18] = "Hillary";
		friends [19] = "Natasha";
		
		int x = 0;
		int totalElements = friends.length;
		
		while (x < totalElements) {
			if (friends[x] == null) {
				x++;
				continue;
			}
			
			System.out.println("I love " + friends[x]);
			x ++;
		}
		
		System.out.println("The iteration is over");
	}

}
