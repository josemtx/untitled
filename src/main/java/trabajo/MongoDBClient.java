package trabajo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONArray;

public class MongoDBClient {
    private MongoClient client;
    private MongoDatabase database;

    public MongoDBClient() {
        client = new MongoClient("localhost", 27017);
        database = client.getDatabase("F1-WeatherRec");
    }

    public void insertSessionsData(JSONArray sessionsData) {
        MongoCollection<Document> collection = database.getCollection("sessions");
        for (int i = 0; i < sessionsData.length(); i++) {
            Document doc = Document.parse(sessionsData.getJSONObject(i).toString());
            collection.insertOne(doc);
        }
    }

    public void insertDriversData(JSONArray driversData) {
        MongoCollection<Document> collection = database.getCollection("drivers");
        for (int i = 0; i < driversData.length(); i++) {
            Document doc = Document.parse(driversData.getJSONObject(i).toString());
            collection.insertOne(doc);
        }
    }

    public void insertStintsData(JSONArray stintsData) {
        MongoCollection<Document> collection = database.getCollection("stints");
        for (int i = 0; i < stintsData.length(); i++) {
            Document doc = Document.parse(stintsData.getJSONObject(i).toString());
            collection.insertOne(doc);
        }
    }

    public void insertWeatherData(JSONArray weatherData) {
        MongoCollection<Document> collection = database.getCollection("weather");
        for (int i = 0; i < weatherData.length(); i++) {
            Document doc = Document.parse(weatherData.getJSONObject(i).toString());
            collection.insertOne(doc);
        }
    }

    public void insertPositionsData(JSONArray positionsData) {
        MongoCollection<Document> collection = database.getCollection("positions");
        for (int i = 0; i < positionsData.length(); i++) {
            Document doc = Document.parse(positionsData.getJSONObject(i).toString());
            collection.insertOne(doc);
        }
    }
}
