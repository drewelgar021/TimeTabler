import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import tgui.TButton;
import tgui.TFrame;
import tgui.TSpinner;
import tgui.TTextField;
import timetable.Timetable;

/**
 * GUI window for adding an Event to a Timetable
 */
public class TimetableDetailsGUI extends TFrame {
    private final Timetable timetable;

    private final JTextField titleInput;
    private final JSpinner startTimeInput;
    private final JSpinner endTimeInput;

    private final TimetableGUI timetableGUI;

    /**
     * Instantiates a new EventInputGUI
     * @param timetable Timetable for the new event to be added to
     */
    public TimetableDetailsGUI(Timetable timetable, TimetableGUI timetableGUI) {
        super("Edit Timetable Details");

        this.timetable = timetable;
        this.timetableGUI = timetableGUI;

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


        startTimeInput = new TSpinner(1.0);
        grid.gridy = 2;

        grid.gridx = 0;
        form.add(new JLabel("Start Time: "), grid);

        grid.gridx = 1;
        form.add(startTimeInput, grid);


        endTimeInput = new TSpinner(1.0);
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
        timetableGUI.reload();
        dispose();
    }
}
