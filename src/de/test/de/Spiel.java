package de.test.de;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;



// D A S    S P I E L    W I R D     G E N E R I E R T

public class Spiel {
    static Integer count = 0;
    static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100 + 1);
    static JLabel text = new JLabel("Gebe eine Zahl zwischen 0 - 100 ein");
    static JTextField textField = new JTextField();
    static JLabel countText = new JLabel();
    static JButton button = new JButton("Abschicken");
    static JFrame frame = new JFrame("Rate die Zahl!");
    static Gui gui = new Gui();


    public static void main(String[] args) {
        Gui.Gui();
    }


    // H I E R     W I R D     D A S     F E N S T E R   G E N E R I E R T





    // T E X T F E L D


    public static boolean guess(Integer number) {
        if (number.equals(myNumber)) {
            text.setText("Richtig geraten!");
            return true;

        } else {
            count ++;

            if(number < myNumber) {
                text.setText("Deine Zahl ist zu klein!");
                textField.setText("");
                countText.setText(String.valueOf("Anzahl der Versuche: " + count));
                return false;
            } else {
                text.setText("Deine Zahl ist zu Groß!");
                textField.setText("");
                countText.setText(String.valueOf("Anzahl der Versuche: " + count));
                return false;
            }

        }
    }
}
