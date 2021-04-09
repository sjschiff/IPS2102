package IPSGUI;
import javax.swing.*;


public class MainMenu extends JFrame{
    //JFrame f;
    public MainMenu(){
        JButton b = new JButton("Click");
        b.setBounds(350,460,100,40);

        add(b);

        setSize(800, 1000);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args){
        new MainMenu();
    }
}
