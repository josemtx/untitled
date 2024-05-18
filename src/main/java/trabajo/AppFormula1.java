package trabajo;

import org.json.JSONArray;

import java.io.IOException;

public class AppFormula1 {
    public static void main(String[] args) throws IOException {
        String sessions = Formula1Service.getSessions();
        JSONArray sessionsArray = new JSONArray(sessions);
        System.out.println(sessionsArray + "\n");

        String drivers = Formula1Service.getDrivers(sessionsArray);
        JSONArray driversArray = new JSONArray(drivers);
        //System.out.println(allDriversArray + "\n");

        String stints = Formula1Service.getStints(sessionsArray);
        JSONArray stintsArray = new JSONArray(stints);
        System.out.println(stintsArray + "\n");



    }
}