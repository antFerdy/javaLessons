
public class TestDog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		dog1.name = "Rex";
		dog1.bark();
		
		Dog [] myDogs = new Dog[3];

		myDogs[2] = dog1;
		myDogs[1] = new Dog();
		myDogs[0] = new Dog();
		
		myDogs[1].name = "Fred";
		myDogs[0].name = "Jorge";
		
		System.out.println("The last dog's name is " + myDogs[2].name);
		
		int x = 0;
		while (x<myDogs.length) {
			myDogs[x].bark();
			x++;
		}
		

	}

}
