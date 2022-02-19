package de.test.de;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static de.test.de.Spiel.*;

public class Gui {


    public static void Gui() {

        frame.setSize(400, 400);
        frame.setLocation(100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

        countText.setBounds(20,20,250,20);


        text.setBounds(50, 50, 500, 30);
        textField.setBounds(50, 100, 200, 30);

        button.setBackground(Color.lightGray);
        button.setBounds(50, 150, 200, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String textFromTextField = textField.getText();
                    Integer number = Integer.parseInt(textFromTextField);
                    if(guess(number) == true) {
                        frame.remove(button);
                    }
                } catch (Exception error){
                    text.setText("Bitte gebe eine Zahl ein!");
                }

            }
        });


        frame.add(countText);
        frame.add(text);
        frame.add(textField);
        frame.setLayout(null);
        frame.add(button);
        frame.setVisible(true);
    }
}
