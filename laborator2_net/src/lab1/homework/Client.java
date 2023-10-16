package lab1.homework;

import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) throws Exception {
		Socket socket = null;
		try {
			InetAddress address = InetAddress.getByName("localhost");
			socket = new Socket(address, 1900);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			for (int i = 0; i < 10; i++) {
				System.out.println("Write 2 numbers separated by space: ");
				String numbers = reader.readLine();
				out.println(numbers);
				String result = in.readLine();
				System.out.println("The procentage of the 2 numbers is: " + result);
			}
			
			out.println("END");
		} catch (Exception ex) {ex.printStackTrace();}
		
		finally {
			socket.close();
		}
	}
}