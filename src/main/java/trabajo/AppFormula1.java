package trabajo;

import org.json.JSONArray;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AppFormula1 {
    public static void main(String[] args) throws IOException {
        List<Integer> years = Arrays.asList(2023, 2024);

        String sessions = Formula1Service.getSessions(years);
        JSONArray sessionsArray = new JSONArray(sessions);
        System.out.println(sessionsArray + "\n");
        JSONArray allSessionsArray = FormulaDataPreprocessor.processSessionsData(sessionsArray);
        //System.out.println(allSessionsArray + "\n");

        String drivers = Formula1Service.getDrivers(sessionsArray);
        JSONArray driversArray = new JSONArray(drivers);
        JSONArray allDriversArray = FormulaDataPreprocessor.processDriversData(driversArray);
        //System.out.println(allDriversArray + "\n");

        String stints = Formula1Service.getStints(sessionsArray);
        JSONArray stintsArray = new JSONArray(stints);
        JSONArray allStintsArray = FormulaDataPreprocessor.processStintsData(stintsArray);
        //System.out.println(allStintsArray + "\n");

        String weather = Formula1Service.getWeather(sessionsArray);
        JSONArray weatherArray = new JSONArray(weather);
        JSONArray allWeatherArray = FormulaDataPreprocessor.processWeatherData(weatherArray);
        //System.out.println(allWeatherArray + "\n");

        String positions = Formula1Service.getPosition(sessionsArray);
        JSONArray positionsArray = new JSONArray(positions);
        JSONArray allPositionsArray = FormulaDataPreprocessor.processPositionData(positionsArray);
        //System.out.println(allPositionsArray + "\n");


    }
}