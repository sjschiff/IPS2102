package IPSGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame{
    //JFrame f;

    private JLabel title;
    private JRadioButton create, delete, update, find, display;
    private JButton select;
    private ButtonGroup choices;

    public MainMenu(ActionListener listener){
        title = new JLabel("Integrated Patient System", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

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

        select = new JButton("Select");


        create.setHorizontalAlignment(JLabel.CENTER);
        delete.setHorizontalAlignment(JLabel.CENTER);
        update.setHorizontalAlignment(JLabel.CENTER);
        find.setHorizontalAlignment(JLabel.CENTER);
        display.setHorizontalAlignment(JLabel.CENTER);

        select.setHorizontalAlignment(JLabel.CENTER);

        choices = new ButtonGroup();

        choices.add(create);
        choices.add(delete);
        choices.add(update);
        choices.add(find);
        choices.add(display);

        add(title);

        add(create);
        add(delete);
        add(update);
        add(find);
        add(display);

        add(select);

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
        //setVisible(true);
    }

    public JButton getSelect(){
        return select;
    }

    public String getSelction(){
        return choices.getSelection().getActionCommand();
    }

    public static void main(String[] args){

    }
}
