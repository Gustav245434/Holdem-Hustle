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
    private JPanel startseitePanel;
    private CardLayout cardLayout;
    private JButton startButton;
    private BufferedImage logo;
    private JLabel picLabel;

    public BufferedImage getLogo() {
        return logo;
    }

    public void setLogo(BufferedImage logo) {
        if(logo == null) return;
        this.logo = logo;
    }

    public JLabel getPicLabel() {
        return picLabel;
    }

    public void setPicLabel(JLabel picLabel) {
        if(picLabel == null) return;
        this.picLabel = picLabel;
    }

    public PokerView() throws IOException {

        setTitle("Holdem Hustle");
        setSize(1100, 600);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dimension.width / 2 - this.getWidth() / 2, dimension.height / 2 - this.getHeight() / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        startseite = new JPanel(cardLayout);

        this.startseitePanel = new JPanel();
        this.startseitePanel.setLayout(new BoxLayout(this.startseitePanel, BoxLayout.Y_AXIS));

        this.logo = ImageIO.read(new File("src/logo.png"));
        Image image = this.logo.getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        this.picLabel = new JLabel();
        this.picLabel.setIcon(icon);
        this.picLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.picLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.startseitePanel.add(this.picLabel);
        this.addComponentListener(new ResizeImageHandler());

        this.startButton = new JButton("Start");
        this.startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.startseitePanel.add(this.startButton);
        startseite.add(this.startseitePanel);

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
