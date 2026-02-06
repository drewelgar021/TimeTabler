import tgui.*;
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
    private JButton cancelButton;
    private JButton addButton;

    /**
     * Instantiates a new EventInputGUI
     * @param timetable Timetable for the new event to be added to
     */
    public MyEventInputGUI(Timetable timetable) {
        super("Add Event");
        this.timetable = timetable;
        this.setSize(500, 600);

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


        startTimeInput = new TSpinner();
        grid.gridy = 2;

        grid.gridx = 0;
        form.add(new JLabel("Start Time: "), grid);

        grid.gridx = 1;
        form.add(startTimeInput, grid);


        endTimeInput = new TSpinner();
        grid.gridy = 3;

        grid.gridx = 0;
        form.add(new JLabel("End Time: "), grid);

        grid.gridx = 1;
        form.add(endTimeInput, grid);


        eventTypeInput = new TComboBox<>(EventType.values());
        grid.gridy = 4;

        grid.gridx = 0;
        form.add(new JLabel("Event Type: "), grid);

        grid.gridx = 1;
        form.add(eventTypeInput, grid);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        grid.gridx = 0;
        grid.gridy = 1;
        this.content().add(buttonPanel, grid);

        cancelButton = new TButton("Cancel");
        addButton = new TButton("Add");

        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(addButton);

    }
}
