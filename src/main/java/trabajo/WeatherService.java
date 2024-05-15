package trabajo;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

public class WeatherService {
    private static final String API_KEY = "fe649f1944e892e7eb8d4a735edd3429";
    private static final String URL_TEMPLATE = "https://api.openweathermap.org/data/2.5/forecast?q=%s&APPID=%s&units=metric";

    public static String getWeatherData(String city, String countryCode) throws Exception {
        String url = String.format(URL_TEMPLATE, city + "," + countryCode, API_KEY);
        Response response = Request.Get(url).execute();
        return response.returnContent().asString();
    }
}
