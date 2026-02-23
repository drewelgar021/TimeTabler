package tgui;

import javax.swing.*;
import java.awt.*;

/**
 * Standardised JTextField for TimeTabler.
 */
public class TTextField extends JTextField {
    public TTextField(int columns) {
        super(columns);
        setStyle();
    }

    public TTextField(String text, int columns) {
        super(text, columns);
        setStyle();
    }

    private void setStyle() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1, true),
                BorderFactory.createEmptyBorder(4, 4, 4, 4)
        ));
    }
}
