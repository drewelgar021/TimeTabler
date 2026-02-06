package tgui;

import javax.swing.*;
import java.awt.*;

public class TSpinner extends JSpinner {
    public TSpinner() {
        super(new SpinnerNumberModel(0.0, 0.0, 24.0, 0.5));
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1, true),
                BorderFactory.createEmptyBorder(4, 4, 4, 4)
        ));

    }
}
