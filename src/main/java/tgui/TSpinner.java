package tgui;

import javax.swing.*;
import java.awt.*;

/**
 * Standardised JSpinner for TimeTabler.
 */
public class TSpinner extends JSpinner {
    public TSpinner(double stepSize) {
        super(new SpinnerNumberModel(0.0, 0.0, 24.0, stepSize));
        setStyle();
    }

    public TSpinner(double value, double stepSize) {
        super(new SpinnerNumberModel(value, 0.0, 24.0, stepSize));
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
