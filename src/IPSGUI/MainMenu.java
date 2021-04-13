package IPSGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame{
    //JFrame f;

    private JLabel title;
    private JRadioButton create, delete, update, find, display;
    private JButton select;

    public MainMenu(ActionListener listener){
        title = new JLabel("Integrated Patient System", JLabel.CENTER);
        title.setFont(new Font("Serif", Font.PLAIN, 25));

        create = new JRadioButton("Create Profile");
        delete = new JRadioButton("Delete Profile");
        update = new JRadioButton("Update Profile");
        find = new JRadioButton("Find/Display Profile");
        display = new JRadioButton("Display All Profiles");

        select = new JButton("Select");


        create.setHorizontalAlignment(JLabel.CENTER);
        delete.setHorizontalAlignment(JLabel.CENTER);
        update.setHorizontalAlignment(JLabel.CENTER);
        find.setHorizontalAlignment(JLabel.CENTER);
        display.setHorizontalAlignment(JLabel.CENTER);

        select.setHorizontalAlignment(JLabel.CENTER);

        ButtonGroup choices = new ButtonGroup();

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

        setSize(400, 500);
        setLayout(new GridLayout(7,0));
        setVisible(true);
    }

    public JButton getSelect(){
        return select;
    }

    public static void main(String[] args){

    }
}
