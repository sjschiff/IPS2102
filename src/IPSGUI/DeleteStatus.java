package IPSGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Class to create a pop-up for the status of the delete
public class DeleteStatus extends JFrame {

    // Declare all needed components
    private JLabel title, message;
    private JButton ok;

    // Constructor method
    public DeleteStatus(ActionListener listener, String status){

        // Create the title
        title = new JLabel("Delete Profile", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        // Create the status message
        message = new JLabel(status, JLabel.CENTER);

        // Create the OK button
        ok = new JButton("OK");
        ok.addActionListener(listener);

        // Handle closing this screen
        JButton exit = new JButton("ExitApp");
        exit.addActionListener(listener);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit.doClick();
            }
        });

        // Add components and set this screen to visible
        add(title);
        add(message);
        add(ok);

            // Set screen format
        setSize(400, 400);
        setLayout(new GridLayout(3,0,0,10));
        setVisible(true);
    }

    // Returns the JButton object of ok
    public JButton getOK(){
        return ok;
    }
}
