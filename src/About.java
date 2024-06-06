package src;

import javax.swing.*;
import java.awt.*;

public class About {
    public static void performAction() {
        JFrame frame = new JFrame("About Us");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel aboutLabel = new JLabel("This is our Java project - Online Cab Booking System");
        aboutLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add an image to the panel
        ImageIcon imageIcon = new ImageIcon("img/about_image.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(aboutLabel);
        panel.add(imageLabel);
        panel.add(Box.createVerticalGlue());

        frame.add(panel);
        frame.setVisible(true);
    }
}
