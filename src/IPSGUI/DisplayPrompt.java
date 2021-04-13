package IPSGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DisplayPrompt extends JFrame {

    private JPanel header, body, footer;
    private JLabel title, adminID, lastName;
    private JTextField adminIDtxt, lastNametxt;
    private JButton search;

    public DisplayPrompt(ActionListener listener){
        // Create header panel and add the title
        header = new JPanel(new GridLayout(1,1));
        title = new JLabel("Display Profile", JLabel.CENTER);
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
        search = new JButton("Search");
        search.addActionListener(listener);
        footer.add(search);

        // Add different panels and set this frame to visible
        add(header);
        add(body);
        add(footer);

        setSize(400, 400);
        setLayout(new GridLayout(3,0,0,10));
        //setVisible(true);
    }

    public static void main(String[] args){
        //new DisplayPrompt();
    }
}
