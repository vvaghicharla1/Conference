import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vvaghicharla on 1/30/2019.
 */
public class GroupConference {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String input = "Writing Fast Tests Against Enterprise Rails 60min\n"
                + "Overdoing it in Python 45min\n"
                + "Lua for the Masses 30min\n"
                + "Ruby Errors from Mismatched Gem Versions 45min\n"
                + "Common Ruby Errors 45min\n"
                + "Rails for Python Developers lightning\n"
                + "Communicating Over Distance 60min\n"
                + "Accounting-Driven Development 45min\n"
                + "Woah 30min\n"
                + "Sit Down and Write 30min\n"
                + "Pair Programming vs Noise 45min\n"
                + "Rails Magic 60min\n"
                + "Ruby on Rails: Why We Should Move On 60min\n"
                + "Clojure Ate Scala (on my project) 45min\n"
                + "Programming in the Boondocks of Seattle 30min\n"
                + "Ruby vs. Clojure for Back-End Development 30min\n"
                + "Ruby on Rails Legacy App Maintenance 60min\n"
                + "A World Without HackerNews 30min\n"
                + "User Interface CSS in Rails Apps 30min";

        String[] information = input.split("\n");

        List<Talk> talks = new ArrayList<>();

        for (int i = 0; i < information.length; i++) {
            String text = information[i];
            String min = text.split(" ")[text.split(" ").length - 1];
            String value = min.substring(0, min.length() - 3);

            int minutes = 0;
            try {
                minutes = Integer.valueOf(value);
            } catch (Exception e) {
                minutes = 5;
            }
            Talk newTalk = new Talk(text, minutes);
            talks.add(newTalk);
        }
        processTasks(talks);
    }

    private static void processTasks(List<Talk> talks){
        final String lunchSession =  "12:00";
        final String networkEventTime =  "17:00";

        List<Talk> morningTalks = new ArrayList<>();
        List<Talk> eveningTalks = new ArrayList<>();
        String updatedTime = "09:00";

        for (Talk talk: talks){
            updatedTime = getIncrementTime(talk.getMinutes(),updatedTime);

            if(LocalTime.parse(updatedTime).getHour() < 12){
                morningTalks.add(talk);
                System.out.println("Morning talk group :" + " " + updatedTime + " "+ talk.getTopic());
            }

            if(updatedTime.equals(lunchSession)) {
                System.out.println(updatedTime + " " + "Lunch");
            }

            if((LocalTime.parse(updatedTime).getHour() > 12 && LocalTime.parse(updatedTime).getHour() <=17)){
                eveningTalks.add(talk);
                System.out.println("evening talks group:" + " " +  updatedTime+ " " + talk.getTopic());
            }

            if(updatedTime.equals(networkEventTime)) {
                System.out.println(updatedTime + " " + "Network event");
            }

            Map<String, List<Talk>> sessionMap =  new HashMap<>();
            sessionMap.put("Morning Session", morningTalks);
            sessionMap.put("Evening Session", eveningTalks);
        }
    }

    private static String getIncrementTime(int min, String updatedString){
        String morningSessionStart = "09:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = null;
        if(updatedString.equalsIgnoreCase("")){
            time = LocalTime.parse(morningSessionStart);
        }else{
            time = LocalTime.parse(updatedString);
        }
        return formatter.format(time.plusMinutes(min));
    }

    private static LocalTime processLocalTime(int min, String updatedString){
        String morningSessionStart = "09:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = null;
            time = LocalTime.parse(updatedString);
        return time.plusMinutes(min);
    }
}
