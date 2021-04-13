package IPSGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UpdateInfo extends JFrame {

    private String id, lName, uField;

    private int componentType;
    private JComboBox comboBox;

    private JPanel header, body, footer;
    private JLabel title, adminID, lastName, updateField;
    private JTextField updateFieldtxt;
    private JComboBox insuTypeDrop, patientTypeDrop, algTypeDrop, illTypeDrop;

    JButton submit;

    public UpdateInfo(ActionListener listener, String id, String lName, String uField){
        this.id = id;
        this.lName = lName;
        this.uField = uField;

        // Arrays to hold choices for drop boxes
        String[] insuTypes = {"Private", "Government"};
        String[] patientTypes = {"Pediatric", "Adult", "Senior"};
        String[] algTypes = {"None", "Food", "Medication", "Other"};
        String[] illTypes = {"None", "CHD", "Diabetes", "Asthma", "Other"};

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

        // Create label
        updateField = new JLabel(uField + ":", JLabel.CENTER);

        // Create input options for the different fields
        updateFieldtxt = new JTextField();
        insuTypeDrop = new JComboBox(insuTypes);
        patientTypeDrop = new JComboBox(patientTypes);
        algTypeDrop = new JComboBox(algTypes);
        illTypeDrop = new JComboBox(illTypes);

        // add proper components to the body
        body.add(updateField);

        switch (uField){
            case "Insurance Type":
                componentType = 0;
                comboBox = insuTypeDrop;
                body.add(insuTypeDrop);
                break;
            case "Patient Type":
                componentType = 0;
                comboBox = patientTypeDrop;
                body.add(patientTypeDrop);
                break;
            case "Allergy Type":
                componentType = 0;
                comboBox = algTypeDrop;
                body.add(algTypeDrop);
                break;
            case "Illness Type":
                componentType = 0;
                comboBox = illTypeDrop;
                body.add(illTypeDrop);
                break;
            default:
                componentType = 1;
                body.add(updateFieldtxt);
                break;
        }


        // Create footer panel
        footer = new JPanel();
        submit = new JButton("Submit");
        submit.addActionListener(listener);
        footer.add(submit);

        // Add different panels and set this frame to visible
        add(header);
        add(body);
        add(footer);

        setSize(400, 500);
        setLayout(new GridLayout(3,0,0,10));
        setVisible(true);
    }

    public JButton getSubmit(){
        return submit;
    }

    // Method to return the data that the user has entered into the fields.
    public String[] getData(){
        String newValue;
        if (componentType == 0){
            newValue = (String)comboBox.getSelectedItem();
        }else{
            newValue = updateFieldtxt.getText();
        }
        String[] rv = {id, lName, uField, newValue};
        return rv;
    }

    // Method to hide this screen and clear what has been entered in the text fields
    public void hideScreen(){
        setVisible(false);
        updateFieldtxt.setText("");
    }
}
