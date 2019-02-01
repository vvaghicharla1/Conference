import java.util.List;
import java.util.Map;

/**
 * Created by vvaghicharla on 1/31/2019.
 */
public class Session {
    private List<Talk> talks;
    private String name;
    private Map<String, List<Talk>> sessionMap;

    public Session(List<Talk> talks) {
        this.talks = talks;
    }

    public Session(){

    }

    public Map<String, List<Talk>> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, List<Talk>> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Talk> getTalks() {
        return talks;
    }

    public void setTalks(List<Talk> talks) {
        this.talks = talks;
    }

    public void addTalk(Talk talk){
        talks.add(talk);
    }

    boolean existTalk(Talk talk){
        for (int i = 0; i < talks.size(); i++) {
            if(talks.get(i).getTopic().equals(talk.getTopic())){
                return true;
            }
        }
        return false;
    }

    void removeTalk(Talk talk){
        for (int i = 0; i < talks.size(); i++) {
            if(talks.get(i).getTopic().equals(talk.getTopic())){
                talks.remove(i);
            }
        }
    }

    int getTotalTalkTime(){
        int total_time=0;

        for (int i = 0; i < talks.size(); i++) {
            total_time+= talks.get(i).getMinutes();
        }
        return total_time;

    }


}

