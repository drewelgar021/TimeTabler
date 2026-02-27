import tgui.TButton;
import tgui.TFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Main application GUI displaying a list of the user's saved timetables.
 */
public class MainGUI extends TFrame implements Reloadable {

    private List<Timetable> timetables;

    /**
     * Instantiates a new MainGUI.
     *
     */
    public MainGUI() {
        super("TimeTabler");

        this.content().setLayout(new GridBagLayout());
        this.setSize(400, 600);

        reload();

    }

    /**
     * Reloads the window to display the current list of timetables.
     */
    public void reload() {

        this.content().removeAll();
        this.content().revalidate();
        this.content().repaint();

        try {
            timetables = new ArrayList<>();
            timetables.addAll(getTimetables());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error: Unable to load timetables: " + e.getMessage()
            );
        }

        GridBagConstraints grid = new GridBagConstraints();
        grid.gridx = 0;
        grid.gridy = 0;

        JLabel appTitle = new JLabel("Timetables");
        appTitle.setFont(TFrame.heading1Font);
        appTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 10));
        this.content().add(appTitle, grid);


        for (Timetable timetable : timetables) {
            grid.gridx = 0;
            grid.gridy++;

            JLabel title = new JLabel(timetable.getTitle());
            title.setFont(TFrame.heading2Font);
            title.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
            this.content().add(title, grid);

            grid.gridx++;
            TButton deleteButton = new TButton("Delete");
            deleteButton.addActionListener(e -> deleteTimetable(timetable));
            this.content().add(deleteButton, grid);

            grid.gridx++;
            TButton openButton = new TButton("Open");
            openButton.addActionListener(e -> openTimetable(timetable));
            this.content().add(openButton, grid);

            grid.gridy++;
            this.content().add(new JLabel(" "), grid); // lazy attempt at spacing
        }

        grid.gridx = 0;
        grid.gridy++;
        TButton addButton = new TButton("Add new");
        addButton.addActionListener(e -> createTimetable());
        this.content().add(addButton, grid);
    }


    private List<Timetable> getTimetables() throws IOException {
        List<Timetable> timetables = new ArrayList<>();
        File timetableDirectory = new File(Main.getDirectory() + "/timetables");
        for (File timetable : Objects.requireNonNull(
                timetableDirectory.listFiles(file -> (file.getName().endsWith(".json")))
        )) {
            timetables.add(TimetableFactory.loadTimetable(timetable.getPath()));
        }

        return timetables;
    }


    private void createTimetable() {
        Timetable timetable = new Timetable("", 0, 0);
        TimetableDetailsGUI timetableDetailsGUI = new TimetableDetailsGUI(timetable, this);
        timetableDetailsGUI.setVisible(true);
    }


    private void deleteTimetable(Timetable timetable) {
        File timetableFile = new File(Main.getDirectory()
                + "/timetables/" + timetable.getTitle() + ".json"
        );

        boolean ignore = timetableFile.delete();
        reload();
    }


    private void openTimetable(Timetable timetable) {
        JFrame timetableGUI = new TimetableGUI(timetable, this);
        timetableGUI.setVisible(true);
    }
}
