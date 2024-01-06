package lab1;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClientSimplu {
    public static void main(String[] args) throws Exception {
        Socket socket = null;

        try {
            // Create an object representing the server's address
            InetAddress serverAddress = InetAddress.getByName("localhost");

            socket = new Socket(serverAddress, 1900);

            // Create an input stream to receive data from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Create an output stream to send data to the server
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            // Read two numbers (x and y) from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter x: ");
            int x = scanner.nextInt();
            System.out.print("Enter y: ");
            int y = scanner.nextInt();

            // Send x and y to the server
            out.println(x);
            out.println(y);
            out.flush();

            // Receive and print the percentage (P) from the server
            String result = in.readLine();
            System.out.println("Percentage: " + result + " %");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            socket.close();
        }
    }
}