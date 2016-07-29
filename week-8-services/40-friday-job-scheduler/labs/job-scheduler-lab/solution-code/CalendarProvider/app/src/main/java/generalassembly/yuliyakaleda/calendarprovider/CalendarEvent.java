package generalassembly.yuliyakaleda.calendarprovider;

/**
 * Created by hollis on 7/28/16.
 */
public class CalendarEvent {
    String organizer, title, location, description;
    long dtStart, dtStop;

    public CalendarEvent(String organizer, String title, String location, String description, long dtStart, long dtStop) {
        this.organizer = organizer;
        this.title = title;
        this.location = location;
        this.description = description;
        this.dtStart = dtStart;
        this.dtStop = dtStop;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDtStart() {
        return dtStart;
    }

    public void setDtStart(long dtStart) {
        this.dtStart = dtStart;
    }

    public long getDtStop() {
        return dtStop;
    }

    public void setDtStop(long dtStop) {
        this.dtStop = dtStop;
    }
}
