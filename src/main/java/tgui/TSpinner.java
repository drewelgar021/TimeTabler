package tgui;

import javax.swing.*;
import java.awt.*;

/**
 * Standardised JSpinner for TimeTabler.
 */
public class TSpinner extends JSpinner {
    public TSpinner(double stepSize) {
        super(new SpinnerNumberModel(0.0, 0.0, 24.0, stepSize));
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1, true),
                BorderFactory.createEmptyBorder(4, 4, 4, 4)
        ));

    }
}
