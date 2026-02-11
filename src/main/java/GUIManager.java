import timetable.Timetable;

import java.sql.Time;

public class GUIManager {
    /**
     * Shows an EventInputGUI allowing the user to add an event to the timetable
     */
    public static void eventInput(Timetable timetable, TimetableGUI GUI) {
        EventInputGUI eventInputGUI = new EventInputGUI(timetable, GUI);
        eventInputGUI.setVisible(true);
    }

    public static void editTimetable(Timetable timetable, TimetableGUI GUI) {
        return;
    }
}
