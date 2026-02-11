import org.xml.sax.SAXException;
import timetable.Event;
import timetable.EventType;
import timetable.Timetable;
import timetable.TimetableFactory;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.time.DayOfWeek;

public class Main {
    public static void main(String[] args)
            throws ParserConfigurationException, IOException, SAXException {
        Timetable timetable = TimetableFactory.loadTimetable("Timetable.xml");


        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("Button.foreground", Color.WHITE);

        JFrame timetableGUI = new TimetableGUI(timetable);
        timetableGUI.setVisible(true);
    }
}
