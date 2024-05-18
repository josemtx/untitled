package trabajo;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.util.List;

public class Formula1Service {
    private static final String URL_TEMPLATE = "https://api.openf1.org/v1/";

    public static String getDrivers(int session_key) throws IOException {
        return makeRequest("drivers?session_key=" + session_key);
    }
    public static String getStints() throws IOException {
        return makeRequest("stints");
    }

    public static String getCarData() throws IOException {
        return makeRequest("car_data");
    }

    public static String getSessions(List<Integer> years) throws IOException {
        StringBuilder combinedResponse = new StringBuilder();
        for (int year : years) {
            String response = makeRequest("sessions?year=" + year + "&session_name=Race");
            combinedResponse.append(response).append("\n");
        }
        return combinedResponse.toString();
    }

    private static String makeRequest(String request) throws IOException {
        String url = String.format(URL_TEMPLATE + request);
        Response response = Request.Get(url).execute();
        return response.returnContent().asString();
    }

}
