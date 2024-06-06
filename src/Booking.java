package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Booking {
    public static void performAction() {
        // Add your logic for Booking option here
        showBookingDialog();
    }

    private static void showBookingDialog() {
        // Create components for booking dialog
        JFrame bookingFrame = new JFrame("Booking Details");
        bookingFrame.setSize(400, 300);
        bookingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel bookingPanel = new JPanel();
        bookingPanel.setLayout(new GridLayout(7, 2));

        JLabel sourceLabel = new JLabel("Source:");
        JComboBox<String> sourceComboBox = new JComboBox<>(getSampleLocations());

        JLabel destinationLabel = new JLabel("Destination:");
        JComboBox<String> destinationComboBox = new JComboBox<>(getSampleLocations());

        JLabel vehicleTypeLabel = new JLabel("Vehicle Type:");
        JComboBox<String> vehicleTypeComboBox = new JComboBox<>(new String[]{"Bike", "Autorickshaw", "Car"});

        JLabel dateTimeLabel = new JLabel("Date & Time:");
        JSpinner dateTimeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateTimeEditor = new JSpinner.DateEditor(dateTimeSpinner, "MM/dd/yyyy HH:mm");
        dateTimeSpinner.setEditor(dateTimeEditor);

        JLabel journeyTypeLabel = new JLabel("Journey Type:");
        JComboBox<String> journeyTypeComboBox = new JComboBox<>(new String[]{"Single Journey", "Round Trip"});

        JButton proceedButton = new JButton("Proceed");

        // Add action listener to the Proceed button
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calculate estimated price and show confirmation dialog
                showConfirmationDialog(sourceComboBox.getSelectedItem().toString(),
                        destinationComboBox.getSelectedItem().toString(),
                        vehicleTypeComboBox.getSelectedItem().toString(),
                        (Date) dateTimeSpinner.getValue(),
                        journeyTypeComboBox.getSelectedItem().toString());
            }
        });

        // Add components to the booking panel
        bookingPanel.add(sourceLabel);
        bookingPanel.add(sourceComboBox);
        bookingPanel.add(destinationLabel);
        bookingPanel.add(destinationComboBox);
        bookingPanel.add(vehicleTypeLabel);
        bookingPanel.add(vehicleTypeComboBox);
        bookingPanel.add(dateTimeLabel);
        bookingPanel.add(dateTimeSpinner);
        bookingPanel.add(journeyTypeLabel);
        bookingPanel.add(journeyTypeComboBox);
        bookingPanel.add(new JLabel()); // Empty label for spacing
        bookingPanel.add(proceedButton);

        // Add booking panel to the frame
        bookingFrame.add(bookingPanel);

        // Display the booking frame
        bookingFrame.setVisible(true);
    }

    private static void showConfirmationDialog(String source, String destination, String vehicleType, Date dateTime, String journeyType) {
        // Add your logic for calculating estimated price here
        double estimatedPrice = calculateEstimatedPrice(source, destination, vehicleType, dateTime, journeyType);

        // Show confirmation dialog
        int choice = JOptionPane.showConfirmDialog(null,
                "Estimated Price: $" + estimatedPrice + "\nDo you want to proceed with the booking?",
                "Booking Confirmation",
                JOptionPane.OK_CANCEL_OPTION);

        if (choice == JOptionPane.OK_OPTION) {
            // Add logic for booking confirmation
            JOptionPane.showMessageDialog(null, "Booking confirmed! Have a safe journey.");
        }
    }

    private static double calculateEstimatedPrice(String source, String destination, String vehicleType, Date dateTime, String journeyType) {
        // Add your logic for calculating estimated price based on source, destination, vehicle type, date & time, and journey type
        // This is a placeholder; you should replace it with your own logic
        return 20.0; // Replace with your calculated price
    }

    private static String[] getSampleLocations() {
        // Add your logic to retrieve or define sample locations
        // This is a placeholder; you should replace it with your own logic
        return new String[]{"Location 1", "Location 2", "Location 3", "Location 4", "Location 5",
                "Location 6", "Location 7", "Location 8", "Location 9", "Location 10"};
    }
}
