package lab2.homework;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class ChatApp {
    public static void main(String args[]) throws IOException {
        JFrame frame = new JFrame("Messaging App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(6, 109, 196));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.setBorder(new RoundedBorder(10));
        frame.add(inputPanel);

        JTextField inputField = new JTextField("Your text here");
        inputField.setPreferredSize(new Dimension(400, 30));
        inputField.setBorder(new RoundedBorder(10));
        inputPanel.add(inputField);

        JTextArea outputArea = new JTextArea();
        outputArea.setPreferredSize(new Dimension(500, 300));
        outputArea.setBorder(new RoundedBorder(10));
        outputArea.setEditable(false);
        frame.add(outputArea);

        JButton button = new JButton("Send");
        button.setForeground(Color.WHITE);
        button.setBorder(new RoundedBorder(10));
        button.addActionListener(e -> new Sender(outputArea).start());
        frame.add(button);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        frame.setVisible(true);

        new Receiver("Serve", inputField).start();
    }
}

class RoundedBorder extends AbstractBorder {
    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
        g.setColor(Color.GRAY);
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}