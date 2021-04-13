package IPSGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorBox extends JFrame {
    private JDialog error;
    private String errorMessage;

    public ErrorBox(String errorMessage){
        this.errorMessage = errorMessage;

        error = new JDialog(this, "ERROR", true);
        error.setLayout(new GridLayout(2,1));

        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setVisible(false);
            }
        });

        JLabel message = new JLabel(errorMessage, JLabel.CENTER);

        error.add(message);
        error.add(ok);
        error.setSize(400,400);
        error.setVisible(true);
    }

    public static void main(String[] args){
        new ErrorBox("Phone number must be all digits no characters");
    }
}
