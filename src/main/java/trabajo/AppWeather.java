package trabajo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONArray;

public class AppWeather {
    public static void main(String[] args) {
        // Configuración del cliente MongoDB
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("F1-WeatherRec");
        MongoCollection<Document> collection = database.getCollection("forecast_data");

        // Instancia de servicios y preprocesador
        WeatherService weatherService = new WeatherService();
        ForecastDataPreprocessor preprocessor = new ForecastDataPreprocessor();


        try {
            String[] cities = {"Manama,bh",
                    "Jeddah,sa",
                    "Melbourne,au",
                    "Suzuka,jp",
                    "Shanghai,cn",
                    "Miami,us",
                    "Imola,it",
                    "Monte-Carlo,mc",
                    "Montreal,ca",
                    "Barcelona,es",
                    "Spielberg,at",
                    "Silverstone,uk",
                    "Budapest,hu",
                    "Spa,be",
                    "Zandvoort,nl",
                    "Monza,it",
                    "Baku,az",
                    "Singapore,sg",
                    "Austin,us",
                    "Ciudad%20de%20Mexico,mx",
                    "Sao%20Paulo,br",
                    "Las%20Vegas,us",
                    "Lusail,qa",
                    "Abu%20Dhabi,ae"};
            for (String city : cities) {
                String rawJson = weatherService.getWeatherData(city.split(",")[0], city.split(",")[1]);
                JSONArray processedData = preprocessor.processForecastData(rawJson);

                for (int i = 0; i < processedData.length(); i++) {
                    Document doc = Document.parse(processedData.getJSONObject(i).toString());
                    collection.insertOne(doc);  // Insertar cada entrada de pronóstico en MongoDB
                }
                System.out.println("Datos de pronóstico almacenados para " + city.split(",")[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mongoClient.close();  // Asegurarse de cerrar la conexión con MongoDB
        }
    }
}
