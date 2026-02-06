package tgui;

import javax.swing.*;
import java.awt.*;

public class TButton extends JButton {
    public TButton(String text) {
        super(text);
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1, true),
                BorderFactory.createEmptyBorder(4, 4, 4, 4)
        ));
    }
}
