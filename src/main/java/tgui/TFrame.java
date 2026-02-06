package tgui;

import javax.swing.*;
import java.awt.*;

/**
 * A JFrame stylised for TimeTabler.
 */
public class TFrame extends JFrame {
    private final JPanel content;

    /**
     * Instantiates a new TFrame.
     * @param title Window title of the TFrame
     */
    public TFrame(String title) {
        super(title);

        content = new JPanel();
        this.add(content);
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        content.setBackground(Color.DARK_GRAY);
        content.setVisible(true);
    }

    /**
     * Returns the content JPanel of the TFrame.
     * @return the content JPanel of the TFrame.
     */
    public JPanel content() {
        return content;
    }
}
