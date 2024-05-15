package trabajo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBClient {
    private MongoClient client;
    private MongoDatabase database;

    public MongoDBClient() {
        client = new MongoClient("localhost", 27017);
        database = client.getDatabase("CLIMATRAVEL");
    }

    public void insertWeatherData(String city, String data) {
        MongoCollection<Document> collection = database.getCollection("consultas_weather");
        Document doc = Document.parse(data);
        doc.append("city", city);
        collection.insertOne(doc);
    }
}
