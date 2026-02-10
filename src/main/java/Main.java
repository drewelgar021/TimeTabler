import timetable.Timetable;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Timetable timetable = new Timetable("Timetable", 4.0, 24.0);

        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("Button.foreground", Color.WHITE);

        JFrame frame = new EventInputGUI(timetable);
        frame.setVisible(true);
    }
}
