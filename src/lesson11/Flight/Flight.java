package lesson11.Flight;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Flight {
    private String number;
    private String from;
    private String to;
    private int duration;
    private boolean isVisaNeed;

    public String getNumber() {
        return number;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isVisaNeed() {
        return isVisaNeed;
    }

    @Override
    public String toString() {
        return number + ' ' + from + ' ' + to + ' ' + duration + " " + isVisaNeed;
    }

    static Map<Integer, Flight> treeMap = new TreeMap<>();

    public Flight(String number, String from, String to, int duration, boolean isVisaNeed) {
        this.number = number;
        this.from = from;
        this.to = to;
        this.duration = duration;
        this.isVisaNeed = isVisaNeed;
    }

    public static void addObjectToTM(Flight flight) throws IOException {
        int key = flight.hashCode();
        treeMap.put(key, flight);
    }

    public static void loadFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filename), StandardCharsets.UTF_8))){
            String line;

            while ((line = reader.readLine()) != null) {
                String regexp_phone = "^[0-9-()]+";
                String regexp_from_to = "[А-Яа-яA-Za-z]+";
                String regexp_dur = "[0-9]+";

                Pattern phone = Pattern.compile(regexp_phone);
                Pattern text = Pattern.compile(regexp_from_to);
                Pattern duration = Pattern.compile(regexp_dur);

                Matcher matcherphone = phone.matcher(line);
                Matcher matcherfrom = text.matcher(line);
                Matcher matcherduration = duration.matcher(line);

                int end = 0;
                String tmptel = null;
                while (matcherphone.find()) {
                    tmptel = matcherphone.group();
                    end = matcherphone.end();
                }

                String tmpfrom = null;
                while (matcherfrom.find(end)){
                    tmpfrom = line.substring(matcherfrom.start(),matcherfrom.end());
                    end = matcherfrom.end();
                    break;
                }

                String tmpto = null;
                while (matcherfrom.find(end)){
                    tmpto = line.substring(matcherfrom.start(),matcherfrom.end());
                    end = matcherfrom.end();
                    break;
                }

                int tmpdur = 0;
                while (matcherduration.find(end)) {
                    tmpdur = Integer.parseInt(line.substring(matcherduration.start(),matcherduration.end()));
                    end = matcherduration.end();
                }

                boolean tmpbool = false;
                while (matcherfrom.find(end)){
                    tmpbool = Boolean.parseBoolean(line.substring(matcherfrom.start(),matcherfrom.end()));
                    end = matcherfrom.end();
                    break;
                }


                addObjectToTM(new Flight(tmptel, tmpfrom, tmpto, tmpdur, tmpbool));
            }
        } catch (IOException e) {
            System.out.println("Ошибка: "+e);
        }
    }
}
