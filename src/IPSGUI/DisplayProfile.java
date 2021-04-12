package IPSGUI;

import javax.swing.*;
import java.awt.*;

public class DisplayProfile extends JFrame {
    // Declare all the components that need to be used
    JPanel header, body, footer;
    JLabel title, adminID, firstName, lastName, address, phone, coPay, insuType, patientType, mdContact, mdPhone, algType, illType,
            adminIDtxt, firstNametxt, lastNametxt, addresstxt, phonetxt, coPaytxt, insuTypetxt, patientTypetxt, mdContacttxt, mdPhonetxt, algTypetxt, illTypetxt;

    JButton next;

    public DisplayProfile(){
        // Create header panel and add the title
        header = new JPanel(new GridLayout(1,1));
        title = new JLabel("Patient Profile", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 25));
        header.add(title);

        // Create body panel with grid layout for 12 inputs and 2 components per input
        body = new JPanel(new GridLayout(12,2,0,5));

            // Create the labels for each input
        adminID = new JLabel("Admin ID:", JLabel.CENTER);
        adminIDtxt = new JLabel("", JLabel.CENTER);
        firstName = new JLabel("First Name:", JLabel.CENTER);
        firstNametxt = new JLabel("", JLabel.CENTER);
        lastName = new JLabel("Last Name:", JLabel.CENTER);
        lastNametxt = new JLabel("", JLabel.CENTER);
        address = new JLabel("Address:", JLabel.CENTER);
        addresstxt = new JLabel("", JLabel.CENTER);
        phone = new JLabel("Phone:", JLabel.CENTER);
        phonetxt = new JLabel("", JLabel.CENTER);
        coPay = new JLabel("Co-Pay:", JLabel.CENTER);
        coPaytxt = new JLabel("", JLabel.CENTER);
        insuType = new JLabel("Insurance Type:", JLabel.CENTER);
        insuTypetxt = new JLabel("", JLabel.CENTER);
        patientType = new JLabel("Patient Type:", JLabel.CENTER);
        patientTypetxt = new JLabel("", JLabel.CENTER);
        mdContact = new JLabel("Md Contact", JLabel.CENTER);
        mdContacttxt = new JLabel("", JLabel.CENTER);
        mdPhone = new JLabel("Md Phone:", JLabel.CENTER);
        mdPhonetxt = new JLabel("", JLabel.CENTER);
        algType = new JLabel("Allergies:", JLabel.CENTER);
        algTypetxt = new JLabel("", JLabel.CENTER);
        illType = new JLabel("Illnesses:", JLabel.CENTER);
        illTypetxt = new JLabel("", JLabel.CENTER);

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
        body.add(insuTypetxt);
        body.add(patientType);
        body.add(patientTypetxt);
        body.add(mdContact);
        body.add(mdContacttxt);
        body.add(mdPhone);
        body.add(mdPhonetxt);
        body.add(algType);
        body.add(algTypetxt);
        body.add(illType);
        body.add(illTypetxt);

        // Create footer panel
        footer = new JPanel();
        next = new JButton("Next Profile");
        footer.add(next);



        // Add different panels and set this frame to visible
        add(header);
        add(body);
        add(footer);

        setSize(400, 800);
        setLayout(new GridLayout(3,0));
        setVisible(true);

    }

    public static void main(String[] args){
        new DisplayProfile();
    }

}
