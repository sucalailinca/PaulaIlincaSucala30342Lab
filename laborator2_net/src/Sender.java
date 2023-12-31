package lab2.homework;

import javax.swing.*;
import java.io.IOException;
import java.net.*;

class Sender extends Thread{

    JTextArea outputArea;
    public Sender(JTextArea outputArea) {
        this.outputArea=outputArea;
    }

    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] buf = new byte[256];
            InetAddress address = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
            socket.send(packet);

            packet= new DatagramPacket(buf, buf.length);
            socket.receive(packet);

            String received = new String(packet.getData());
            outputArea.append("\n>"+received);

            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}