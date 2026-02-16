import timetable.Timetable;
import timetable.TimetableFactory;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args)
            throws IOException {

        File timetableFile = new File("timetables/Timetable.json");
        // Create a new empty timetable if one does not exist
        if (!timetableFile.exists()) {
            TimetableFactory.saveTimetable(new Timetable("Timetable", 6, 22),
                    "timetables/Timetable.json");
        }

        Timetable timetable = TimetableFactory.loadTimetable("timetables/Timetable.json");


        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("Button.foreground", Color.WHITE);

        JFrame timetableGUI = new TimetableGUI(timetable);
        timetableGUI.setVisible(true);
    }
}
