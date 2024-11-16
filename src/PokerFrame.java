import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokerFrame extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;

    public PokerFrame() {
        // Hauptfenster einstellen
        setTitle("Java Swing Navigation");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CardLayout und Hauptpanel initialisieren
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Erstelle die einzelnen "Seiten"
        JPanel homePanel = createHomePanel();
        JPanel subPagePanel = createSubPagePanel();

        // Füge die Seiten dem Hauptpanel hinzu
        mainPanel.add(homePanel, "Home");
        mainPanel.add(subPagePanel, "SubPage");

        // Hauptpanel zum JFrame hinzufügen
        add(mainPanel);

        // Setze die Startseite auf "Home"
        cardLayout.show(mainPanel, "Home");
    }

    private JPanel createHomePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Willkommen auf der Hauptseite!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        JButton buttonToSubPage = new JButton("Zur Unterseite");
        buttonToSubPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Wechsel zur Unterseite
                cardLayout.show(mainPanel, "SubPage");
            }
        });
        panel.add(buttonToSubPage, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createSubPagePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Dies ist die Unterseite!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        JButton buttonToHomePage = new JButton("Zurück zur Hauptseite");
        buttonToHomePage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Wechsel zur Hauptseite
                cardLayout.show(mainPanel, "Home");
            }
        });
        panel.add(buttonToHomePage, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PokerFrame frame = new PokerFrame();
                frame.setVisible(true);
            }
        });
    }

}
