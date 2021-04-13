package IPSGUI;

import backend.MedCond;
import backend.PatientProf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Class to display the data of a Patient Profile
public class DisplayProfile extends JFrame {
    // Declare all the components that need to be used
    private JPanel header, body, footer;
    private JLabel title, adminID, firstName, lastName, address, phone, coPay, insuType, patientType, mdContact, mdPhone, algType, illType,
            adminIDtxt, firstNametxt, lastNametxt, addresstxt, phonetxt, coPaytxt, insuTypetxt, patientTypetxt, mdContacttxt, mdPhonetxt, algTypetxt, illTypetxt;

    private JButton next, exit;

    // Constructor to create the display profile window
    // Takes a listener to handle all the actions, a Patient Profile to display, and a boolean to see if this is the last
    // profile to be displayed before returning to the main menu
    public DisplayProfile(ActionListener listener, PatientProf profile, boolean last){
        MedCond medCondInfo = profile.getMedCondInfo();

        // Create header panel and add the title
        header = new JPanel(new GridLayout(1,1));
        title = new JLabel("Patient Profile", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 25));
        header.add(title);

        // Create body panel with grid layout for 12 inputs and 2 components per input
        body = new JPanel(new GridLayout(12,2,0,5));

            // Create the labels for each input
        adminID = new JLabel("Admin ID:", JLabel.CENTER);
        adminIDtxt = new JLabel(profile.getadminID(), JLabel.CENTER);
        firstName = new JLabel("First Name:", JLabel.CENTER);
        firstNametxt = new JLabel(profile.getFirstName(), JLabel.CENTER);
        lastName = new JLabel("Last Name:", JLabel.CENTER);
        lastNametxt = new JLabel(profile.getLastName(), JLabel.CENTER);
        address = new JLabel("Address:", JLabel.CENTER);
        addresstxt = new JLabel(profile.getAddress(), JLabel.CENTER);
        phone = new JLabel("Phone:", JLabel.CENTER);
        phonetxt = new JLabel(profile.getPhone(), JLabel.CENTER);
        coPay = new JLabel("Co-Pay:", JLabel.CENTER);
        coPaytxt = new JLabel(String.valueOf(profile.getCoPay()), JLabel.CENTER);
        insuType = new JLabel("Insurance Type:", JLabel.CENTER);
        insuTypetxt = new JLabel(profile.getInsuType(), JLabel.CENTER);
        patientType = new JLabel("Patient Type:", JLabel.CENTER);
        patientTypetxt = new JLabel(profile.getPatientType(), JLabel.CENTER);
        mdContact = new JLabel("Md Contact", JLabel.CENTER);
        mdContacttxt = new JLabel(medCondInfo.getMdContact(), JLabel.CENTER);
        mdPhone = new JLabel("Md Phone:", JLabel.CENTER);
        mdPhonetxt = new JLabel(medCondInfo.getMdPhone(), JLabel.CENTER);
        algType = new JLabel("Allergies:", JLabel.CENTER);
        algTypetxt = new JLabel(medCondInfo.getAlgType(), JLabel.CENTER);
        illType = new JLabel("Illnesses:", JLabel.CENTER);
        illTypetxt = new JLabel(medCondInfo.getIllType(), JLabel.CENTER);

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
        // Add either a Next Profile button or an Exit button depending on if this is the last profile to be displayed
        footer = new JPanel();
        next = new JButton("Next Profile");
        next.addActionListener(listener);
        exit = new JButton("Exit");
        exit.addActionListener(listener);

        if (last){
            footer.add(exit);
        }else{
            footer.add(next);
        }

        // Add different panels and set this frame to visible
        add(header);
        add(body);
        add(footer);

        setSize(400, 800);
        setLayout(new GridLayout(3,0));
        setVisible(true);

    }

    // Return the JButton object for next
    public JButton getNext(){
        return next;
    }

    // Return the JButton object for exit
    public JButton getExit(){
        return exit;
    }

    // Test main
    public static void main(String[] args){
        //new DisplayProfile();
    }

}
