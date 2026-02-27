import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args)
            throws IOException {

        File timetableFile = new File(getDirectory() + "/timetables/Timetable.json");
        // Create a new empty timetable if one does not exist
        if (!timetableFile.exists()) {
            TimetableFactory.saveTimetable(new Timetable("Timetable", 6, 22),
                    getDirectory() + "/timetables/Timetable.json");
        }

        Timetable timetable = TimetableFactory.loadTimetable(
                getDirectory() + "/timetables/Timetable.json");


        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("Button.foreground", Color.WHITE);

        JFrame mainGUI = new MainGUI();
        mainGUI.setVisible(true);
    }

    public static String getDirectory() {
        try {
            File jarFile = new File(Main.class
                    .getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI()
            );
            return jarFile.getParentFile().getParentFile().getAbsolutePath();
        } catch (URISyntaxException e) {
            throw new RuntimeException("Failed to find project directory: " + e.getMessage());
        }
    }
}
