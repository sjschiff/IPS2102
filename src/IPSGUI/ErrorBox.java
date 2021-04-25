package IPSGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class to display and error message pop up
public class ErrorBox extends JFrame {
    // Declare needed components
    private JDialog error;
    private String errorMessage;

    // Constructor method
    // Takes in an errorMessage to be displayed
    public ErrorBox(String errorMessage){
        this.errorMessage = errorMessage;

        // Create error DialogBox
        error = new JDialog(this, "ERROR", true);
        error.setLayout(new GridLayout(2,1));

        // Create a button that will close the dialog box when clicked
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setVisible(false);
            }
        });

        // Create a label to show the error message
        JLabel message = new JLabel(errorMessage, JLabel.CENTER);

        // Add components, set format, and show window
        error.add(message);
        error.add(ok);
        error.setSize(400,400);
        error.setVisible(true);
    }

}
