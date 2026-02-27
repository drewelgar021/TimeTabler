import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.*;

import tgui.TButton;
import tgui.TFrame;
import tgui.TSpinner;
import tgui.TTextField;

/**
 * GUI window for adding an Event to a Timetable
 */
public class TimetableDetailsGUI extends TFrame {
    private final Timetable timetable;

    private final JTextField titleInput;
    private final JSpinner startTimeInput;
    private final JSpinner endTimeInput;

    private Reloadable parentWindow;

    /**
     * Instantiates a new EventInputGUI.
     * @param timetable Timetable for the new event to be added to.
     * @param parentWindow The parent TimetableGUI window.
     */
    public TimetableDetailsGUI(Timetable timetable, Reloadable parentWindow) {
        super("Edit Timetable Details");

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

        titleInput = new TTextField(timetable.getTitle(), 16);
        grid.gridy = 0;

        grid.gridx = 0;
        form.add(new JLabel("Title: "), grid);

        grid.gridx = 1;
        form.add(titleInput, grid);


        startTimeInput = new TSpinner(timetable.getStartTime(), 1.0);
        grid.gridy = 2;

        grid.gridx = 0;
        form.add(new JLabel("Start Time: "), grid);

        grid.gridx = 1;
        form.add(startTimeInput, grid);


        endTimeInput = new TSpinner(timetable.getEndTime(), 1.0);
        grid.gridy = 3;

        grid.gridx = 0;
        form.add(new JLabel("End Time: "), grid);

        grid.gridx = 1;
        form.add(endTimeInput, grid);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        grid.gridx = 0;
        grid.gridy = 1;
        this.content().add(buttonPanel, grid);

        JButton cancelButton = new TButton("Cancel");
        cancelButton.addActionListener(e -> dispose());

        JButton saveButton = new TButton("Save");
        saveButton.addActionListener(e -> save());

        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(20));
        buttonPanel.add(saveButton);
    }

    public void save() {
        String title = titleInput.getText().trim();
        int startTime = Math.toIntExact(Math.round((double) startTimeInput.getValue()));
        int endTime = Math.toIntExact(Math.round((double) endTimeInput.getValue()));

        timetable.setTitle(title);
        timetable.setStartTime(startTime);
        timetable.setEndTime(endTime);

        try {
            timetable.save();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to save timetable: " + e.getMessage());
        }

        parentWindow.reload();
        dispose();
    }
}
