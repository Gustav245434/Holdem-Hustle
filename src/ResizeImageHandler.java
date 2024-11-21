import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;

public class ResizeImageHandler implements ComponentListener {
    @Override
    public void componentResized(ComponentEvent e) {
        if(e == null || e.getComponent() == null) return;
        if (e.getComponent() instanceof PokerView view) {
            Image image = calculateScaledImage(view.getLogo(), view.getWidth(), view.getHeight());
            ImageIcon icon = new ImageIcon(image);
            view.getPicLabel().setIcon(icon);
        }
    }

    /**
     * Berechnet die maximale Größe eines Bildes, ohne es zu dehnen
     * @param image Bild von dem die Größe berechnet werden soll
     * @param maxWidth Maximale Breite des Bildes
     * @param maxHeight Maximale Höhe des Bildes
     * @return Geändertes Bild mit optimaler Größe
     */
    private static Image calculateScaledImage(BufferedImage image, int maxWidth, int maxHeight) {
        int width = image.getWidth();
        int height = image.getHeight();
        double ratio = (double) width / height;

        if (maxWidth / ratio > maxHeight) {
            return image.getScaledInstance((int) (maxHeight * ratio), maxHeight, Image.SCALE_DEFAULT);
        } else {
            return image.getScaledInstance(maxWidth, (int) (maxWidth / ratio), Image.SCALE_DEFAULT);
        }

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
