package IPSGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Class to create the main menu of the program
public class MainMenu extends JFrame{
    // Declare necessary components
    private JLabel title;
    private JRadioButton create, delete, update, find, display;
    private JButton select;
    private ButtonGroup choices;

    // Constructor method
    public MainMenu(ActionListener listener){
        // Create header and add a title
        title = new JLabel("Integrated Patient System", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        // Create radio buttons for each possible selection and add a corresponding action command
        create = new JRadioButton("Create Profile");
        create.setActionCommand("create");
        delete = new JRadioButton("Delete Profile");
        delete.setActionCommand("delete");
        update = new JRadioButton("Update Profile");
        update.setActionCommand("update");
        find = new JRadioButton("Find/Display Profile");
        find.setActionCommand("find");
        display = new JRadioButton("Display All Profiles");
        display.setActionCommand("displayAll");

        // Create a select button
        select = new JButton("Select");

        // Center each button
        create.setHorizontalAlignment(JLabel.CENTER);
        delete.setHorizontalAlignment(JLabel.CENTER);
        update.setHorizontalAlignment(JLabel.CENTER);
        find.setHorizontalAlignment(JLabel.CENTER);
        display.setHorizontalAlignment(JLabel.CENTER);

        select.setHorizontalAlignment(JLabel.CENTER);

        // Create a button group and add each radio button so that only one of the above can be selected
        choices = new ButtonGroup();

        choices.add(create);
        choices.add(delete);
        choices.add(update);
        choices.add(find);
        choices.add(display);

        // Add all components
        add(title);

        add(create);
        add(delete);
        add(update);
        add(find);
        add(display);

        add(select);

        // Add action listener for select button
        select.addActionListener(listener);

        // Handle closing this screen
        JButton exit = new JButton("ExitApp");
        exit.addActionListener(listener);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit.doClick();
            }
        });

        // Set the layout of this screen
        setSize(400, 500);
        setLayout(new GridLayout(7,0));
    }

    // Method to get the JButton object for select
    public JButton getSelect(){
        return select;
    }

    // Method to get which button is selected
    public String getSelction(){
        return choices.getSelection().getActionCommand();
    }

}
