import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Startseite extends JPanel {

    private JLabel picLabel;
    private BufferedImage logo;
    private JButton quitButton, startButton, optionButton;
    private JPanel buttonPanel;

    public JLabel getPicLabel() {
        return picLabel;
    }

    public void setPicLabel(JLabel picLabel) {
        this.picLabel = picLabel;
    }

    public BufferedImage getLogo() {
        return logo;
    }

    public void setLogo(BufferedImage logo) {
        this.logo = logo;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public void setQuitButton(JButton quitButton) {
        this.quitButton = quitButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JButton getOptionButton() {
        return optionButton;
    }

    public void setOptionButton(JButton optionButton) {
        this.optionButton = optionButton;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public Startseite() throws IOException {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.logo = ImageIO.read(new File("src/logo.png"));
        Image image = this.logo.getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        this.picLabel = new JLabel();
        this.picLabel.setIcon(icon);
        this.picLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.picLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(this.picLabel);

        this.startButton = new JButton("Beginnen");
        this.startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.optionButton = new JButton("Optionen");
        this.optionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.quitButton = new JButton("Beenden");
        this.quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.quitButton.addActionListener(new QuitButtonListener());

        this.buttonPanel = new JPanel();
        this.buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.buttonPanel.setLayout(new FlowLayout());
        this.buttonPanel.add(startButton);
        this.buttonPanel.add(optionButton);
        this.buttonPanel.add(quitButton);

        this.add(this.buttonPanel);

    }

}
