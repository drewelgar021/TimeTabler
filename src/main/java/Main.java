import timetable.Event;
import timetable.EventType;
import timetable.Timetable;

import javax.swing.*;
import java.awt.*;
import java.time.DayOfWeek;

public class Main {
    public static void main(String[] args) {
        Timetable timetable = new Timetable("Timetable", 4, 24);

        timetable.addEvent(new Event(
                "Work", "Truck Open", DayOfWeek.WEDNESDAY, 4, 12,
                EventType.WORK));

        timetable.addEvent(new Event(
                "CSSE2002 LEC", "Hawken Engineering Building", DayOfWeek.TUESDAY,
                16, 18, EventType.CLASS
        ));
        timetable.addEvent(new Event(
                "CSSE2010 LEC", "Hawken Engineering Building", DayOfWeek.TUESDAY,
                8, 9, EventType.CLASS
        ));

        timetable.addEvent(new Event(
                "Work", "Close", DayOfWeek.SUNDAY, 15.5, 23.5,
                EventType.WORK
        ));


        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("Button.foreground", Color.WHITE);

        JFrame timetableGUI = new TimetableGUI(timetable);
        timetableGUI.setVisible(true);
    }
}
