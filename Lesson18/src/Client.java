import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;



public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// �������� �� ���������� ����������
		if(args.length == 0) {
			System.out.println("Please insert correct argument");
			System.exit(0);
		}
		
		//������� �����
		Socket clientSocket = null;
		
		//������� ��������� � �������� ������
		BufferedReader reader = null;
		OutputStream out = null;
		
		
		try {
			//����������� � ������ ������� ������� ���� ����� � ���� 3000
			clientSocket = new Socket("localhost",3000);
			
			//�������� ������ ������
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = clientSocket.getOutputStream();
			
			//���������� �� ������ ����� ����� ����������� ���������� ������
			out.write((args[0] + "\n").getBytes());
			out.write(("End\n").getBytes());
			
			//�������� � ����������� ������ ������
			String quote; 
			while(true) {
				quote = reader.readLine();
				if(quote == "End") {
					break;
				}
				//���������� ������
				System.out.println("���������� ������ � ������ " + args[0] + ":" + quote);
				
			}
			
		}
			//����������� ����������
		catch (UnknownHostException e1) {
			
			System.out.println("��������� ����������");
			
		}
		
		catch(IOException e2) {
			
			System.out.println("������ ��� ������ �����");
		}
		
		
		finally {
			
			try {
				reader.close();
				out.flush();
				out.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
			
		}
	}

}
