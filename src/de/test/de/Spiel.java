package de.test.de;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

    // S T A T I S C H E   V A R I A B L E N

public class Spiel {
    static Integer count = 0;
    static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    static JLabel text = new JLabel("Gebe eine Zahl zwischen 0 - 100 ein");
    static JTextField textField = new JTextField();
    static JLabel countText = new JLabel("Anzahl der Versuche: " + String.valueOf(count));

    public static void main(String[] args) {
        openUi();
    }


    // H I E R     W I R D     D A S     F E N S T E R   G E N E R I E R T


    public static void openUi() {
        JFrame frame = new JFrame("Rate die Zahl!");
        frame.setSize(400, 400);
        frame.setLocation(100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

        countText.setBounds(20,20,250,20);


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


        frame.add(countText);
        frame.add(text);
        frame.add(textField);
        frame.setLayout(null);
        frame.add(button);
        frame.setVisible(true);
}

    // T E X T F E L D


    public static void guess(Integer number) {
        if (number.equals(myNumber)) {
            text.setText("Richtig geraten!");
        } else {
            count ++;
            if(number < myNumber) {
                text.setText("Deine Zahl ist zu klein!");
            } else {
                text.setText("Deine Zahl ist zu Groß!");
            }
            textField.setText("");
            countText.setText(String.valueOf("Anzahl der Versuche: " + count));

        }
    }
}
