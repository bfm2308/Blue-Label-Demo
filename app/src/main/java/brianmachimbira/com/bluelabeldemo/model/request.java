package brianmachimbira.com.bluelabeldemo.model;


public class request {
    public String EventType;
    public Event event;

    public request(String eventType, Event event) {
        this.EventType = eventType;
        this.event = event;
    }
}
