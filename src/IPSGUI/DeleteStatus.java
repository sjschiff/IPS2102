package IPSGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Class to create a pop-up for the status of the delete
public class DeleteStatus extends JFrame {
    private JLabel title, message;
    private JButton ok;

    public DeleteStatus(ActionListener listener, String status){

        // Create the title
        title = new JLabel("Delete Profile", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        // Create the status message
        message = new JLabel(status, JLabel.CENTER);

        // Create the OK button
        ok = new JButton("OK");
        ok.addActionListener(listener);

        add(title);
        add(message);
        add(ok);

        setSize(400, 400);
        setLayout(new GridLayout(3,0,0,10));
        setVisible(true);
    }

    // Returns the JButton object of ok
    public JButton getOK(){
        return ok;
    }
}
