package eus.uni.dam.bat;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Ariketabat {
	
	public static void main( String[] args ) {
	
	 String uri = "mongodb+srv://user1:user1@cluster0.wcdu5.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
	    try (MongoClient mongoClient = MongoClients.create(uri)) {
	        MongoDatabase database = mongoClient.getDatabase("sample_mflix");
	        MongoCollection<Document> collection = database.getCollection("movies");
	        collection.find().forEach(doc -> System.out.println("Pelikulak:"+ doc.toJson()));;
	      
	        
	    }
}

}
