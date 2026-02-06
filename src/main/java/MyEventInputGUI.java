package tgui;

import timetable.EventType;
import timetable.Timetable;

import javax.swing.*;
import java.awt.*;

/**
 * GUI window for adding an Event to a Timetable
 */
public class MyEventInputGUI extends TFrame {
    private Timetable timetable;

    private JTextField titleInput;
    private JTextArea descriptionInput;
    private JSpinner startTimeInput;
    private JSpinner endTimeInput;
    private JComboBox<EventType> eventTypeInput;
    private JButton CancelButton;
    private JButton addButton;

    /**
     * Instantiates a new EventInputGUI
     * @param timetable Timetable for the new event to be added to
     */
    public MyEventInputGUI(Timetable timetable) {
        super("Add Event");
        this.timetable = timetable;
        this.setSize(500, 600);
        GridBagConstraints grid = new GridBagConstraints();
        grid.insets = new Insets(5, 5, 5, 5);

        titleInput = new TTextField(16);

        grid.gridx = 0;
        grid.gridy = 0;
        this.content().add(new JLabel("Title:"));

        grid.gridx = 1;
        this.content().add(titleInput);

    }
}
