package timetable;

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


    public Timetable(String title, int startTime, int endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }


    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }


    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void removeEvent(Event event) {
        events.remove(event);
    }
    
}
