package trabajo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class AppFormula1 {
    public static void main(String[] args) throws IOException {
        List<Integer> years = List.of(2023, 2024);
        String sessions = Formula1Service.getSessions(years);
        JSONArray sessionsArray = new JSONArray(sessions);
        //System.out.println(sessions + "\n");


        for (int i = 0; i < sessionsArray.length(); i++) {
            JSONObject session = sessionsArray.getJSONObject(i);
            int session_key = session.getInt("session_key");
            String drivers = Formula1Service.getDrivers(session_key);
            JSONArray driversArray = new JSONArray(drivers);
            for (int j = 0; j < driversArray.length(); j++) {
                JSONObject driver = driversArray.getJSONObject(j);
                //System.out.println(driver + "\n");
            }
        }

    }
}