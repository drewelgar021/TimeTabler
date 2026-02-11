package tgui;

import javax.swing.*;
import java.awt.*;

/**
 * Standardised JFrame for TimeTabler.
 */
public class TFrame extends JFrame {
    private final JPanel content;
    public static final Font heading1Font = new Font("defaultFont", Font.BOLD, 20);
    public static final Font heading2Font = new Font("defaultFont", Font.BOLD, 16);
    /**
     * Instantiates a new TFrame.
     * @param title Window title of the TFrame
     */
    public TFrame(String title) {
        super(title);

        content = new JPanel();
        JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        this.add(scrollPane);
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
