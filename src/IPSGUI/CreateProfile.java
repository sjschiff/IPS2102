package IPSGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateProfile extends JFrame {

    // Declare all the components that need to be used
    private final JPanel header, body, footer;
    private final JLabel title, adminID, firstName, lastName, address, phone, coPay, insuType, patientType, mdContact, mdPhone, algType, illType;
    private final JTextField adminIDtxt, firstNametxt, lastNametxt, addresstxt, phonetxt, coPaytxt, mdContacttxt, mdPhonetxt;
    private final JComboBox insuTypeDrop, patientTypeDrop, algTypeDrop, illTypeDrop;
    private final JButton submit;

    public CreateProfile(ActionListener listener){
        // Create header panel and add the title
        header = new JPanel(new GridLayout(1,1));
        title = new JLabel("Create Profile", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 25));
        header.add(title);

        // Create body panel with grid layout for 12 inputs and 2 components per input
        body = new JPanel(new GridLayout(12,2,0,5));

            // Arrays to hold choices for drop boxes
        String[] insuTypes = {"Private", "Government"};
        String[] patientTypes = {"Pediatric", "Adult", "Senior"};
        String[] algTypes = {"None", "Food", "Medication", "Other"};
        String[] illTypes = {"None", "CHD", "Diabetes", "Asthma", "Other"};

            // Create the labels for each input
        adminID = new JLabel("Admin ID:", JLabel.CENTER);
        firstName = new JLabel("First Name:", JLabel.CENTER);
        lastName = new JLabel("Last Name:", JLabel.CENTER);
        address = new JLabel("Address:", JLabel.CENTER);
        phone = new JLabel("Phone:", JLabel.CENTER);
        coPay = new JLabel("Co-Pay:", JLabel.CENTER);
        insuType = new JLabel("Insurance Type:", JLabel.CENTER);
        patientType = new JLabel("Patient Type:", JLabel.CENTER);
        mdContact = new JLabel("Md Contact", JLabel.CENTER);
        mdPhone = new JLabel("Md Phone:", JLabel.CENTER);
        algType = new JLabel("Allergies:", JLabel.CENTER);
        illType = new JLabel("Illnesses:", JLabel.CENTER);

            // Create all the areas to input information
        adminIDtxt = new JTextField();
        firstNametxt = new JTextField();
        lastNametxt = new JTextField();
        addresstxt = new JTextField();
        phonetxt = new JTextField();
        coPaytxt = new JTextField();
        insuTypeDrop = new JComboBox(insuTypes);
        patientTypeDrop = new JComboBox(patientTypes);
        mdContacttxt = new JTextField();
        mdPhonetxt = new JTextField();
        algTypeDrop = new JComboBox(algTypes);
        illTypeDrop = new JComboBox(illTypes);

            // Add each component to the body in order
        body.add(adminID);
        body.add(adminIDtxt);
        body.add(firstName);
        body.add(firstNametxt);
        body.add(lastName);
        body.add(lastNametxt);
        body.add(address);
        body.add(addresstxt);
        body.add(phone);
        body.add(phonetxt);
        body.add(coPay);
        body.add(coPaytxt);
        body.add(insuType);
        body.add(insuTypeDrop);
        body.add(patientType);
        body.add(patientTypeDrop);
        body.add(mdContact);
        body.add(mdContacttxt);
        body.add(mdPhone);
        body.add(mdPhonetxt);
        body.add(algType);
        body.add(algTypeDrop);
        body.add(illType);
        body.add(illTypeDrop);

        // Create footer panel
        footer = new JPanel();
        submit = new JButton("Submit");
        submit.addActionListener(listener);
        footer.add(submit);

        // Add different panels and set this frame to visible
        add(header);
        add(body);
        add(footer);

        setSize(400, 800);
        setLayout(new GridLayout(3,0));
        //setVisible(true);


    }

    public JButton getSubmit(){
        return submit;
    }

    public static void main(String[] args){
        //new CreateProfile();
    }
}

