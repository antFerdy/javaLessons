import java.util.Formatter;
import java.util.Scanner;


public class FormatterTest {
	static Formatter a;
	public static void main(String[] args) {
		try {
			a = new Formatter("C:\\Users\\zhumagulov_r\\workspace\\Lesson16\\src\\res\\1.txt");
			Scanner scn = new Scanner(System.in);
			
			System.out.println("������� ��� ��� ? "); 
			int age = Integer.parseInt(scn.next());
			
			System.out.println("������ �� ?");
			String plc = scn.next();
			
			System.out.println("��� ��� ����� ?");
			String name = scn.next();
			
			a.format("���� ����� %s, ��� %d ��� � � �� ������ %s",name,age,plc);
			System.out.printf("���� ����� %s, ��� %d ��� � � �� ������ %s",name,age,plc);
			a.close();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
