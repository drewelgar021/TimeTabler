import timetable.Timetable;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Timetable timetable = new Timetable("Timetable", 4.0F, 24.0F);

        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("Button.foreground", Color.WHITE);

        JFrame frame = new MyEventInputGUI(timetable);
        frame.setVisible(true);
    }
}
