package TGUI;

import javax.swing.*;
import java.awt.*;

public class TFrame extends JFrame {
    public TFrame(String title) {
        super(title);
        this.getContentPane().setBackground(Color.DARK_GRAY);

        JPanel content = new JPanel();
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        content.setVisible(true);

        JButton testButton = new JButton("Test");
        content.add(testButton);
        testButton.setVisible(true);


    }
}
