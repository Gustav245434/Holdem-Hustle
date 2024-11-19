import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class PokerView extends JFrame {

    private JPanel startseite;
    private CardLayout cardLayout;
    private JButton startButton;

    public PokerView() throws IOException {

        setTitle("Holdem Hustle");
        setSize(1100, 600);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dimension.width / 2 - this.getWidth() / 2, dimension.height / 2 - this.getHeight() / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        startseite = new JPanel(cardLayout);

        BufferedImage myPicture = ImageIO.read(new File("src/logo.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        add(picLabel, BorderLayout.PAGE_START);

        this.startButton = new JButton("Start");
        add(this.startButton, BorderLayout.CENTER);

        // Füge die Seiten dem Hauptpanel hinzu
        //startseite.add(homePanel, "Home");
        //startseite.add(subPagePanel, "SubPage");

        // Hauptpanel zum JFrame hinzufügen
        add(startseite);

        // Setze die Startseite auf "Home"
        cardLayout.show(startseite, "Home");

        this.setVisible(true);
    }
}
