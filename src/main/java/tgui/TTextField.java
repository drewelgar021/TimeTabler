package tgui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TTextField extends JTextField {
    public TTextField(int columns) {
        super(columns);
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1, true),
                BorderFactory.createEmptyBorder(4, 4, 4, 4)
        ));
    }
}
