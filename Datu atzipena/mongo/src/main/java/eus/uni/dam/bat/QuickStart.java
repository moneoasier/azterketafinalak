/*mongodb+srv://<username>:<password>@cluster0.wcdu5.mongodb.net/myFirstDatabase?retryWrites=true&w=majority*/


package eus.uni.dam.bat;
	
	import static com.mongodb.client.model.Filters.eq;
	import org.bson.Document;
	import com.mongodb.client.MongoClient;
	import com.mongodb.client.MongoClients;
	import com.mongodb.client.MongoCollection;
	import com.mongodb.client.MongoDatabase;
public class QuickStart {
	

	public static void main( String[] args ) {
	    // Replace the uri string with your MongoDB deployment's connection string
	    String uri = "mongodb+srv://user1:user1@cluster0.wcdu5.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
	    try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase("sample_mflix");
	        MongoCollection<Document> collection = database.getCollection("movies");
	        Document doc = collection.find(eq("title", "Back to the Future")).first();
	        System.out.println(doc.toJson());
	    }
	}

}
