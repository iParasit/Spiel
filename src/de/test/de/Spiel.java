package de.test.de;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.concurrent.ThreadLocalRandom;

public class Spiel {
    static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    static Integer count = 0;
    static JLabel text = new JLabel("Gebe eine Zahl zwischen 0 - 100 ein");
    static JTextField textField = new JTextField();

    public static void main(String[] args) {
        openUi();
    }

    public static void openUi() {
        JFrame frame = new JFrame("Rate die Zahl!");
        frame.setSize(400, 400);
        frame.setLocation(100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);


        text.setBounds(50, 50, 500, 30);


        textField.setBounds(50, 100, 200, 30);

        JButton button = new JButton("Abschicken");
        button.setBounds(50, 150, 200, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String textFromTextField = textField.getText();
                    Integer number = Integer.parseInt(textFromTextField);
                    guess(number);
                } catch (Exception error){
                    text.setText("Bitte gebe eine Zahl ein!");
                }

            }
        });


        frame.add(text);
        frame.add(textField);
        frame.setLayout(null);
        frame.add(button);
        frame.setVisible(true);
}

    public static void guess(Integer number) {
        if (number.equals(myNumber)) {
            text.setText("Richtig geraten! Du hast " + count + " versuche gebraucht!");
        } else {
            count ++;
            if(number < myNumber) {
                text.setText("Falsch geraten! Deine Zahl ist zu klein!");
            } else {
                text.setText("Deine Zahl ist zu Groß!");
            }
            textField.setText("");
        }
    }
}
