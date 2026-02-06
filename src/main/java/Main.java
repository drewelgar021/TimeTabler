import tgui.EventInputGUI;
import timetable.Timetable;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Timetable timetable = new Timetable();

        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("TextArea.foreground", Color.WHITE);

        JFrame frame = new EventInputGUI(timetable);
        frame.setVisible(true);
}
}
