package IPSGUI;

import javax.swing.*;
import java.awt.*;

public class DeleteProfile extends JFrame {
    JPanel header, body, footer;
    JLabel title, adminID, lastName;
    JTextField adminIDtxt, lastNametxt;
    JButton delete;

    public DeleteProfile(){

        // Create header panel and add the title
        header = new JPanel(new GridLayout(1,1));
        title = new JLabel("Delete Profile", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 25));
        header.add(title);

        // Create body panel with grid layout for 2 inputs and 2 components per input
        body = new JPanel(new GridLayout(2,2,0,30));

            // Create the labels for each input
        adminID = new JLabel("Admin ID:", JLabel.CENTER);
        lastName = new JLabel("Last Name:", JLabel.CENTER);

            // Create all the areas to input information
        adminIDtxt = new JTextField();
        lastNametxt = new JTextField();

            // Add each component to the body in order
        body.add(adminID);
        body.add(adminIDtxt);
        body.add(lastName);
        body.add(lastNametxt);

        // Create footer panel
        footer = new JPanel();
        delete = new JButton("Delete");
        footer.add(delete);

        // Add different panels and set this frame to visible
        add(header);
        add(body);
        add(footer);

        setSize(400, 400);
        setLayout(new GridLayout(3,0,0,10));
        setVisible(true);

        new DeleteStatus("Profile Deleted");
    }

    // Class to create a pop-up for the status of the delete
    private class DeleteStatus extends JFrame{
        JLabel title, message;
        JButton ok;

        public DeleteStatus(String status){

            // Create the title
            title = new JLabel("Delete Profile", JLabel.CENTER);
            title.setFont(new Font("Serif", Font.PLAIN, 25));

            // Create the status message
            message = new JLabel(status, JLabel.CENTER);

            // Create the OK button
            ok = new JButton("OK");

            add(title);
            add(message);
            add(ok);

            setSize(400, 400);
            setLayout(new GridLayout(3,0,0,10));
            setVisible(true);
        }
    }

    public static void main(String[] args){
        new DeleteProfile();
    }

}


