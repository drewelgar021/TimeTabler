/**
 * Manages opening and of GUI windows.
 */
public class GUIManager {
    /**
     * Creates a new EventInputGUI.
     * @param timetable The timetable being edited.
     * @param timetableGUI The TimetableGUI to be reloaded when the event is added.
     */
    public static void eventInput(Timetable timetable, TimetableGUI timetableGUI) {
        EventInputGUI eventInputGUI = new EventInputGUI(timetable, timetableGUI);
        eventInputGUI.setVisible(true);
    }

    /**
     * Creates a new TimetableDetailsGUI
     * @param timetable The timetable being edited.
     * @param timetableGUI The TimetableGUI to be reloaded when the timetable details are updated.
     */
    public static void editTimetable(Timetable timetable, TimetableGUI timetableGUI) {
        TimetableDetailsGUI timetableDetailsGUI = new TimetableDetailsGUI(timetable, timetableGUI);
        timetableDetailsGUI.setVisible(true);
    }
}
