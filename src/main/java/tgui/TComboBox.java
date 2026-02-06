package tgui;

import javax.swing.*;
import java.awt.*;

public class TComboBox<E> extends JComboBox<E> {
    public TComboBox(E[] values) {
        super(values);
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1, true),
                BorderFactory.createEmptyBorder(4, 4, 4, 4)
        ));
    }
}
