package IPSGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Class to create GUI to choose which profile and what field to update
public class UpdateProfile extends JFrame {
    // Declare needed components
    JPanel header, body, footer;
    JLabel title, adminID, lastName, updateField;
    JTextField adminIDtxt, lastNametxt;
    JComboBox updateFieldDrop;
    JButton find;

    // Constructor method
    public UpdateProfile(ActionListener listener){
        // Create header panel and add the title
        header = new JPanel(new GridLayout(1,1));
        title = new JLabel("Update Profile", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 25));
        header.add(title);

        // Create body panel with grid layout for 3 inputs and 2 components per input
        body = new JPanel(new GridLayout(3,2,0,30));

            // Create choices for update fields
            String[] fields = {"Address", "Phone Number", "Insurance Type", "Co-pay", "Patient Type", "Medical Contact", "Medical Contact Phone Number", "Allergy Type", "Illness Type"};

            // Create the labels for each input
        adminID = new JLabel("Admin ID:", JLabel.CENTER);
        lastName = new JLabel("Last Name:", JLabel.CENTER);
        updateField = new JLabel("Update Field:", JLabel.CENTER);

            // Create all the areas to input information
        adminIDtxt = new JTextField();
        lastNametxt = new JTextField();
        updateFieldDrop = new JComboBox(fields);

            // Add each component to the body in order
        body.add(adminID);
        body.add(adminIDtxt);
        body.add(lastName);
        body.add(lastNametxt);
        body.add(updateField);
        body.add(updateFieldDrop);

        // Create footer panel
        footer = new JPanel();
        find = new JButton("Find");
        find.addActionListener(listener);
        footer.add(find);

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

        setSize(400, 500);
        setLayout(new GridLayout(3,0,0,10));

    }

    // Returns the JButton object of find
    public JButton getFind(){
        return find;
    }

    // Method to return the data that the user has entered into the fields.
    public String[] getData(){
        String adminID = adminIDtxt.getText();
        String lastName = lastNametxt.getText();
        String updateField = (String)updateFieldDrop.getSelectedItem();
        String[] data = {adminID, lastName, updateField};
        return data;
    }

    // Method to hide this screen and clear what has been entered in the text fields
    public void hideScreen(){
        setVisible(false);
        adminIDtxt.setText("");
        lastNametxt.setText("");
        updateFieldDrop.setSelectedIndex(0);
    }

}
