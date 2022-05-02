package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


// Represents a log of patient screen events using Singleton Design Patter
// Singleton Design Pattern to ensure there is only one EventLog in the program
// and such that the program has global access to this single instance of EventLog
public class EventLog implements Iterable<Event> {
    //single instance of EventLog
    private static EventLog eventLog;
    private Collection<Event> events;

    // EFFECTS: Constructs single instance of EventLog
    //          with respect to Singleton Design Pattern
    public EventLog() {
        events = new ArrayList<Event>();
    }

    // EFFECTS: returns the single instance of EventLog
    //          else, creates the single instance if it doesn't already exist
    public static EventLog getInstance() {
        if (eventLog == null) {
            eventLog = new EventLog();
        }

        return eventLog;
    }

    // MODIFIES: this
    // EFFECTS: Adds and logs an event to the event log
    public void logEvent(Event e) {
        events.add(e);
    }

    public void clearEventLog() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
