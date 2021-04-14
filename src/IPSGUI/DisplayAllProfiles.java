package IPSGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Class to prompt the user for adminID to see all profiles under that ID
public class DisplayAllProfiles extends JFrame{

    // Declare each component needed
    private JPanel header, body, footer;
    private JLabel title, adminID;
    private JTextField adminIDtxt;
    private JButton search;

    // Constructor to create the displayAllProfiles prompt screen
    public DisplayAllProfiles(ActionListener listener){
        // Create header panel and add the title
        header = new JPanel(new GridLayout(1,1));
        title = new JLabel("Display All Profiles", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 25));
        header.add(title);

        // Create body panel with grid layout for 1 input and 2 components per input
        body = new JPanel(new GridLayout(1,2,0,30));

            // Create the label and area to enter the adminID
        adminID = new JLabel("Admin ID:", JLabel.CENTER);
        adminIDtxt = new JTextField();

            // Add each component to the body in order
        body.add(adminID);
        body.add(adminIDtxt);

            // Create footer panel
        footer = new JPanel();
        search = new JButton("Search");
        search.addActionListener(listener);
        footer.add(search);

        // Handle closing this screen
        JButton exit = new JButton("ExitApp");
        exit.addActionListener(listener);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit.doClick();
            }
        });

            // Add different panels and set this frame format
        add(header);
        add(body);
        add(footer);

        setSize(400, 400);
        setLayout(new GridLayout(3,0,0,60));

    }

    // Method to return the JButton object for search
    public JButton getSearch() {
        return search;
    }

    // Method to return the adminID that the user has entered
    public String getData(){
        return adminIDtxt.getText();
    }

    // Method to hide this screen and clear what has been entered in the text field
    public void hideScreen(){
        setVisible(false);
        adminIDtxt.setText("");
    }

    public static void main(String[] args){
        //new DisplayAllProfiles();
    }


}
