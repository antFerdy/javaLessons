import java.util.Formatter;
import java.util.Scanner;


public class FormatterTest {
	static Formatter a;
	public static void main(String[] args) {
		try {
			a = new Formatter("C:\\Users\\zhumagulov_r\\workspace\\Lesson16\\src\\res\\1.txt");
			Scanner scn = new Scanner(System.in);
			
			System.out.println("Сколько вам лет ? "); 
			int age = Integer.parseInt(scn.next());
			
			System.out.println("Откуда вы ?");
			String plc = scn.next();
			
			System.out.println("Как вас зовут ?");
			String name = scn.next();
			
			a.format("Меня зовут %s, мне %d лет и я из города %s",name,age,plc);
			System.out.printf("Меня зовут %s, мне %d лет и я из города %s",name,age,plc);
			a.close();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
