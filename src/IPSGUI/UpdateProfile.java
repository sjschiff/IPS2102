package IPSGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UpdateProfile extends JFrame {

    JPanel header, body, footer;
    JLabel title, adminID, lastName, updateField;
    JTextField adminIDtxt, lastNametxt;
    JComboBox updateFieldDrop;
    JButton find;

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
        footer.add(find);

        // Add different panels and set this frame to visible
        add(header);
        add(body);
        add(footer);

        setSize(400, 500);
        setLayout(new GridLayout(3,0,0,10));
        //setVisible(true);

    }

    private class UpdateInfo extends JFrame{
        JPanel header, body, footer;
        JLabel title, adminID, lastName, updateField;
        JTextField updateFieldtxt;

        JButton submit;

        public UpdateInfo(String id, String lName, String uField){
            // Create header panel and add the title
            header = new JPanel(new GridLayout(3,1));
            title = new JLabel("Update", JLabel.CENTER);
            title.setFont(new Font("Serif", Font.PLAIN, 25));

            adminID = new JLabel("Admin ID - " + id, JLabel.CENTER);
            lastName = new JLabel("Last Name - " + lName, JLabel.CENTER);

            header.add(title);
            header.add(adminID);
            header.add(lastName);

            // Create body panel with grid layout for 1 inputs and 2 components per input
            body = new JPanel(new GridLayout(1,2,0,30));

                // Create label and input for update field
            updateField = new JLabel(uField + ":", JLabel.CENTER);
            updateFieldtxt = new JTextField();

                // add these components to the body
            body.add(updateField);
            body.add(updateFieldtxt);

            // Create footer panel
            footer = new JPanel();
            submit = new JButton("Find");
            footer.add(submit);

            // Add different panels and set this frame to visible
            add(header);
            add(body);
            add(footer);

            setSize(400, 500);
            setLayout(new GridLayout(3,0,0,10));
            //setVisible(true);
        }
    }

    public static void main(String[] args){
        //new UpdateProfile();
    }
}
