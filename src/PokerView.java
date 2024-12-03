import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PokerView extends JFrame {

    private JPanel startseiteCard;
    private CardLayout cardLayout;
    private Startseite startseite;

    public Startseite getStartseite() {
        return startseite;
    }

    public PokerView() throws IOException {

        setTitle("Holdem Hustle");
        setSize(1100, 600);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dimension.width / 2 - this.getWidth() / 2, dimension.height / 2 - this.getHeight() / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        startseiteCard = new JPanel(cardLayout);

        this.startseite = new Startseite();
        startseiteCard.add(this.startseite);

        add(startseiteCard);

        cardLayout.show(startseiteCard, "Home");
        this.addComponentListener(new ResizeImageHandler());

        this.setVisible(true);
    }

}
