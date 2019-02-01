/**
 * Created by vvaghicharla on 1/31/2019.
 */
public class Talk {

    private String topic;
    private int minutes;

    public Talk(String topic, int minutes) {
        this.topic = topic;
        this.minutes = minutes;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

}
