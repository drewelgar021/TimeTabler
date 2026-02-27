/**
 * Manages opening and of GUI windows.
 */
public class GUIManager {
    /**
     * Creates a new EventInputGUI.
     *
     * @param timetable    The timetable being edited.
     * @param parentWindow  The parent window to be reloaded when the event is created.
     */
    public static void eventInput(Timetable timetable, Reloadable parentWindow) {
        EventInputGUI eventInputGUI = new EventInputGUI(timetable, parentWindow);
        eventInputGUI.setVisible(true);
    }

    /**
     * Creates a new TimetableDetailsGUI
     * @param timetable The timetable being edited.
     * @param parentWindow The parent window to be reloaded when the timetable details are updated.
     */
    public static void editTimetable(Timetable timetable, Reloadable parentWindow) {
        TimetableDetailsGUI timetableDetailsGUI = new TimetableDetailsGUI(timetable, parentWindow);
        timetableDetailsGUI.setVisible(true);
    }
}
