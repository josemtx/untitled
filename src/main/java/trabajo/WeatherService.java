package trabajo;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class WeatherApiClient {
    private static final String API_KEY = "fe649f1944e892e7eb8d4a735edd3429";
    private static final String URL_TEMPLATE = "https://api.openweathermap.org/data/2.5/forecast";

    public static JSONObject getWeather(String city) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(String.format(URL_TEMPLATE, city, API_KEY));
            String response = EntityUtils.toString(httpClient.execute(request).getEntity());
            return new JSONObject(response);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
