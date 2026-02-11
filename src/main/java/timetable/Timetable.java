package timetable;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representation of a timetable. Stores multiple events.
 */
public class Timetable {
    private String title;
    private final List<Event> events = new ArrayList<>();
    private int startTime;
    private int endTime;


    /**
     * Instantiates a new Timetable
     * @param title Title of the timetable.
     * @param startTime Start time of the timetable (relevant for PDF outputting).
     * @param endTime End timet of the timetable (relevant for PDF outputting).
     */
    public Timetable(String title, int startTime, int endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns the title of the timetable.
     * @return Title of the timetable.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Changes the title of the timetable.
     * @param title New title for the timetable.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the start time of the timetable.
     * @return Start time of the timetable.
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * Changes the start time of the timetable.
     * @param startTime New start time for the timetable.
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }


    /**
     * Returns the end time of the timetable.
     * @return End time of the timetable.
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * Changes the end time of the timetable.
     * @param endTime End time of the timetable.
     */
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }


    /**
     * Returns the events in this timetable.
     * @return List of events in this timetable.
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Adds an event to this timetable.
     * @param event Event to be added to this timetable.
     */
    public void addEvent(Event event) {
        events.add(event);
    }

    /**
     * Removes an event from this timetable.
     * @param event Event to be removed from this timetable.
     */
    public void removeEvent(Event event) {
        events.remove(event);
    }

    /**
     * Saves this timetable to a .xml file.
     * @throws ParserConfigurationException if a DocumentBuilder cannot be created
     * @throws TransformerException if an error occurs during XML transformation
     */
    public void save() throws ParserConfigurationException, TransformerException {
        TimetableFactory.saveTimetable(this, title + ".xml");
    }
    
}
