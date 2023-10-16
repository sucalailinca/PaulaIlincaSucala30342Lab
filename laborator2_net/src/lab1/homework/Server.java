package lab1.homework;

import java.net.*;
import java.io.*;

public class Server{
	public static void main(String[] args) throws IOException {
		ServerSocket ss = null;
		Socket socket = null;
		
		try {
			String line = "";
			ss = new ServerSocket(1900);
			System.out.println("The server is waiting for connection...");
			socket = ss.accept();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
		
			InetSocketAddress remoteAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHost = remoteAddress.getHostName();
			int remotePort = remoteAddress.getPort();
			
			System.out.println("New client connected: " + remoteHost + " " + remotePort);
			
			while(!line.equals("END")) {
				line = in.readLine();
				System.out.println("The server receptioned: ");
				String[] numbers = line.split(" ");
				float num1 = Integer.parseInt(numbers[0]);
				float num2 = Integer.parseInt(numbers[1]);
				float result = num1 * 100 / num2;
				
				out.println(String.format("%.2f", result));
				out.flush();
				
			}
			System.out.println("Server application finished.");
		} catch(Exception e) {e.printStackTrace();}
		
		finally {
			ss.close();
			if (socket!=null)
				socket.close();
		}
	}
}