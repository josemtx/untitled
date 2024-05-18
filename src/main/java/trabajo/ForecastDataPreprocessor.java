package trabajo;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

public class ForecastDataPreprocessor {

    public JSONArray processForecastData(String rawJson) {
        JSONObject json = new JSONObject(rawJson);
        JSONArray list = json.getJSONArray("list");
        JSONObject cityInfo = json.getJSONObject("city");
        String cityName = cityInfo.getString("name");
        JSONArray processedList = new JSONArray();

        for (int i = 0; i < list.length(); i++) {
            JSONObject forecast = list.getJSONObject(i);
            String dt_txt = forecast.getString("dt_txt"); // Fecha y hora del pronóstico

            // Filtrar para incluir solo entradas a las 12:00 PM
            if (dt_txt.endsWith("12:00:00")) {
                JSONObject main = forecast.getJSONObject("main");
                JSONObject weather = forecast.getJSONArray("weather").getJSONObject(0);
                JSONObject wind = forecast.getJSONObject("wind");

                String description = weather.getString("description");
                double temp = main.getDouble("temp");
                double windSpeed = wind.getDouble("speed");

                Document document = new Document()
                        .append("city", cityName)
                        .append("datetime", dt_txt)
                        .append("description", description)
                        .append("temperature", new Document().append("current", temp)
                        .append("windSpeed", windSpeed));

                processedList.put(document);
            }
        }

        return processedList;
    }
}
