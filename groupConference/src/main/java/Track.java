import java.util.List;

/**
 * Created by vvaghicharla on 1/31/2019.
 */
public class Track {
    private String title;
    private int time;
    private List<Session> sessions;

    Track(String title, int time, List<Session> sessions) {
        this.title = title;
        this.time = time;
        this.sessions = sessions;
    }

    public Track() {
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


}
