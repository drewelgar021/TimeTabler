import tgui.TFrame;
import timetable.Event;
import timetable.EventType;
import timetable.Timetable;

import javax.swing.*;
import java.awt.*;

public class SampleEventInputGUI extends TFrame {
    private Timetable timetable;

    private JTextField titleField;
    private JTextArea descriptionArea;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JComboBox<EventType> eventTypeCombo;
    private JButton addButton;
    private JButton cancelButton;

    public SampleEventInputGUI(Timetable timetable) {
        super("Add Event");
        this.timetable = timetable;
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        mainPanel.add(new JLabel("Title:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        titleField = new JTextField(20);
        mainPanel.add(titleField, gbc);

        // Description
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        mainPanel.add(new JLabel("Description:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        descriptionArea = new JTextArea(5, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        mainPanel.add(scrollPane, gbc);

        // Start Time
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(new JLabel("Start Time:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        startTimeField = new JTextField(10);
        mainPanel.add(startTimeField, gbc);

        // End Time
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        mainPanel.add(new JLabel("End Time:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        endTimeField = new JTextField(10);
        mainPanel.add(endTimeField, gbc);

        // Event Type
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        mainPanel.add(new JLabel("Event Type:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        eventTypeCombo = new JComboBox<>(EventType.values());
        mainPanel.add(eventTypeCombo, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        addButton = new JButton("Add Event");
        cancelButton = new JButton("Cancel");

        addButton.addActionListener(e -> addEvent());
        cancelButton.addActionListener(e -> dispose());

        buttonPanel.add(cancelButton);
        buttonPanel.add(addButton);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        mainPanel.add(buttonPanel, gbc);

        this.add(mainPanel);
    }

    private void addEvent() {
        try {
            String title = titleField.getText().trim();
            String description = descriptionArea.getText().trim();
            float startTime = Float.parseFloat(startTimeField.getText().trim());
            float endTime = Float.parseFloat(endTimeField.getText().trim());
            EventType eventType = (EventType) eventTypeCombo.getSelectedItem();

            if (title.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Title cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (startTime >= endTime) {
                JOptionPane.showMessageDialog(this, "Start time must be before end time", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Event event = new Event(title, description, startTime, endTime, eventType);
            timetable.addEvent(event);

            JOptionPane.showMessageDialog(this, "Event added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid time format. Please enter numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
