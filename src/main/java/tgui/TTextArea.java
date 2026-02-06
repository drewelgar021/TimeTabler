package tgui;

import javax.swing.*;
import java.awt.*;

public class TTextArea extends JTextArea {
    public TTextArea(int rows, int columns) {
        super(rows, columns);
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1, true),
                BorderFactory.createEmptyBorder(4, 4, 4, 4)
        ));
        this.setLineWrap(true);
    }
}
