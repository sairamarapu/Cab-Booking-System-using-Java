package src;

import javax.swing.*;
import java.awt.*;

public class ContactUs {
    public static void performAction() {
        JFrame frame = new JFrame("Contact Us");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JLabel phoneNumberValue = new JLabel("+11234567890");

        JLabel emailLabel = new JLabel("Email:");
        JLabel emailValue = new JLabel("support@onlinecabbookingsystem.com");

        JLabel addressLabel = new JLabel("Address:");
        JLabel addressValue = new JLabel("SR University, Warangal");

        JLabel availabilityLabel = new JLabel("Availability Timings:");
        JLabel availabilityValue = new JLabel("24X365");

        panel.add(phoneNumberLabel);
        panel.add(phoneNumberValue);
        panel.add(emailLabel);
        panel.add(emailValue);
        panel.add(addressLabel);
        panel.add(addressValue);
        panel.add(availabilityLabel);
        panel.add(availabilityValue);

        frame.add(panel);
        frame.setVisible(true);
    }
}
