import org.xml.sax.SAXException;
import timetable.Timetable;
import timetable.TimetableFactory;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args)
            throws ParserConfigurationException, IOException, SAXException, TransformerException {

        File timetableFile = new File("timetables/Timetable.xml");
        // Create a new empty timetable if one does not exist
        if (!timetableFile.exists()) {
            TimetableFactory.saveTimetable(new Timetable("Timetable", 6, 6),
                    "Timetable.xml");
        }

        Timetable timetable = TimetableFactory.loadTimetable("timetables/Timetable.xml");


        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("Button.foreground", Color.WHITE);

        JFrame timetableGUI = new TimetableGUI(timetable);
        timetableGUI.setVisible(true);
    }
}
