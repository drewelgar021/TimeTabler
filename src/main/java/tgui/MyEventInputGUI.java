import timetable.Timetable;
import tgui.TFrame;

import javax.swing.*;

public class MyEventInputGUI extends TFrame {
    private Timetable timetable;

    public MyEventInputGUI(Timetable timetable) {
        super("Add Timetable.Event");
        this.timetable = timetable;
        this.setSize(500, 600);

        this.content().add(new JLabel("Title:"));

    }
}
