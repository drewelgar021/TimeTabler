import tgui.*;

import javax.swing.*;
import java.awt.*;
import java.time.DayOfWeek;

/**
 * GUI window for adding an Event to a Timetable
 */
public class EventInputGUI extends TFrame {
    private final Timetable timetable;

    private final JTextField titleInput;
    private final JTextArea descriptionInput;
    private final JComboBox<DayOfWeek> dayInput;
    private final JSpinner startTimeInput;
    private final JSpinner endTimeInput;
    private final JComboBox<EventType> eventTypeInput;

    private final Reloadable parentWindow;

    /**
     * Instantiates a new EventInputGUI
     * @param timetable Timetable for the new event to be added to
     */
    public EventInputGUI(Timetable timetable, Reloadable parentWindow) {
        super("Add Event");

        this.timetable = timetable;
        this.parentWindow = parentWindow;

        this.setSize(400, 500);

        this.content().setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        grid.gridy = 0;
        JPanel form = new JPanel(new GridBagLayout());
        this.content().add(form, grid);
        form.setOpaque(false);
        form.setVisible(true);

        grid.insets = new Insets(10, 10, 10, 10);

        titleInput = new TTextField(16);
        grid.gridy = 0;

        grid.gridx = 0;
        form.add(new JLabel("Title: "), grid);

        grid.gridx = 1;
        form.add(titleInput, grid);


        descriptionInput = new TTextArea(4, 16);
        grid.gridy = 1;

        grid.gridx = 0;
        form.add(new JLabel("Description: "), grid);

        grid.gridx = 1;
        form.add(descriptionInput, grid);


        dayInput = new TComboBox<>(DayOfWeek.values());
        grid.gridy = 2;

        grid.gridx = 0;
        form.add(new JLabel("Day: "), grid);

        grid.gridx = 1;
        form.add(dayInput, grid);


        startTimeInput = new TSpinner(0.5);
        grid.gridy = 3;

        grid.gridx = 0;
        form.add(new JLabel("Start Time: "), grid);

        grid.gridx = 1;
        form.add(startTimeInput, grid);


        endTimeInput = new TSpinner(0.5);
        grid.gridy = 4;

        grid.gridx = 0;
        form.add(new JLabel("End Time: "), grid);

        grid.gridx = 1;
        form.add(endTimeInput, grid);


        eventTypeInput = new TComboBox<>(EventType.values());
        grid.gridy = 5;

        grid.gridx = 0;
        form.add(new JLabel("Event Type: "), grid);

        grid.gridx = 1;
        form.add(eventTypeInput, grid);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        grid.gridx = 0;
        grid.gridy = 1;
        this.content().add(buttonPanel, grid);

        JButton cancelButton = new TButton("Cancel");
        cancelButton.addActionListener(e -> dispose());

        JButton addButton = new TButton("Add");
        addButton.addActionListener(e -> addEvent());

        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(addButton);
    }

    /**
     * Adds a new event to the timetable based on the values in each input field.
     */
    public void addEvent() {
        String title = titleInput.getText().trim();
        String description = descriptionInput.getText().trim();
        DayOfWeek day = (DayOfWeek) dayInput.getSelectedItem();
        double startTime = (double) startTimeInput.getValue();
        double endTime = (double) endTimeInput.getValue();
        EventType eventType = (EventType) eventTypeInput.getSelectedItem();

        timetable.addEvent(new Event(title, description, day, startTime, endTime, eventType));
        this.parentWindow.reload();
        dispose();
    }
}
