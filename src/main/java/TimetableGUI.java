import tgui.TButton;
import tgui.TFrame;
import timetable.Event;
import timetable.Timetable;

import javax.swing.*;
import java.awt.*;
import java.time.DayOfWeek;
import java.util.Comparator;
import java.util.List;

/**
 * A GUI displaying a timetable's events.
 */
public class TimetableGUI extends TFrame {

    Timetable timetable;

    /**
     * Instantiates a new EventInputGUI.
     *
     * @param timetable The timetable to be displayed
     */
    public TimetableGUI(Timetable timetable) {
        super(timetable.getTitle());

        this.timetable = timetable;

        this.content().setLayout(new GridBagLayout());
        this.setSize(500, 600);

        reload();
    }

    /**
     * Reloads the window to display current timetable data.
     */
    public void reload() {
        this.content().removeAll();
        this.content().revalidate();
        this.content().repaint();
        this.setTitle(timetable.getTitle());

        try {
            timetable.save();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving timetable.");
        }

        GridBagConstraints grid = new GridBagConstraints();

        grid.gridy = 0;
        grid.gridx = 0;

        TButton addButton = new TButton("Add Event");
        addButton.addActionListener(e -> GUIManager.eventInput(timetable, this));
        this.content().add(addButton, grid);

        grid.gridx = 1;
        TButton editButton = new TButton("Edit Timetable Details");
        editButton.addActionListener(e -> GUIManager.editTimetable(timetable, this));
        this.content().add(editButton, grid);

        for (DayOfWeek day : DayOfWeek.values()) {
            grid.gridy++;
            grid.gridx = 0;

            JLabel dayLabel = new JLabel(day.name());
            dayLabel.setFont(TFrame.heading1Font);
            dayLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 10));
            this.content().add(dayLabel, grid);

            List<Event> dayEvents = timetable.getEvents().stream()
                    .filter(e -> e.getDay() == day)
                    .sorted(Comparator.comparingDouble(Event::getStartTime)).toList();

            if (dayEvents.isEmpty()) {
                grid.gridy++;
                JLabel noEvents = new JLabel("No events");
                noEvents.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
                this.content().add(noEvents, grid);
            }

            for (Event event : dayEvents) {
                grid.gridy++;

                grid.gridx = 0;
                JLabel eventTitle = new JLabel(event.getTitle());
                eventTitle.setFont(TFrame.heading2Font);
                eventTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
                this.content().add(eventTitle, grid);

                grid.gridx = 1;
                JLabel startTime = new JLabel("Start: "
                        // conversion to base 60 for time
                        + String.format(
                                "%02d:%02d",
                                (int) Math.floor(event.getStartTime()),
                                (int) ((event.getStartTime()
                                        - Math.floor(event.getStartTime())) * 60
                                ))
                );
                startTime.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
                this.content().add(startTime, grid);

                grid.gridx = 2;
                TButton removeButton = new TButton("Remove");
                removeButton.addActionListener(e -> removeEvent(event));
                this.content().add(removeButton, grid);

                grid.gridy++;

                grid.gridx = 0;
                JLabel eventDescription = new JLabel(event.getDescription());
                eventDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 10));
                this.content().add(eventDescription, grid);

                grid.gridx = 1;
                JLabel endTime = new JLabel(
                        "End: "
                                // conversion to base 60 for time
                                + String.format("%02d:%02d",
                                        (int) Math.floor(event.getEndTime()),
                                        (int) ((event.getEndTime()
                                                - Math.floor(event.getEndTime())) * 60))
                );
                endTime.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 10));
                this.content().add(endTime, grid);
            }
        }


    }

    /**
     * Removes an event from the timetable and reloads the window to display changes.
     * @param event Event to be removed from the timetable.
     */
    public void removeEvent(Event event) {
        timetable.removeEvent(event);
        reload();
    }
}
