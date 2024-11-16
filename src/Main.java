import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new PokerView();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to start.");
        }
    }
}