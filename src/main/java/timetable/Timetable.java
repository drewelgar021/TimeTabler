package timetable;

import java.util.ArrayList;
import java.util.List;

public class Timetable {
    private String title;
    private final List<Event> events = new ArrayList<>();
    private double startTime;
    private double endTime;


    public Timetable(String title, double startTime, double endTime) {
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


    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }


    public double getEndTime() {
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
