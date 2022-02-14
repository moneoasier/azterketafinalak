package eus.uni.dam.bat;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Ariketa10 {

	public static void main( String[] args ) {
		
		 String uri = "mongodb+srv://user1:user1@cluster0.wcdu5.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
		    try (MongoClient mongoClient = MongoClients.create(uri)) {
		        MongoDatabase database = mongoClient.getDatabase("sample_mflix");
		        MongoCollection<Document> collection = database.getCollection("movies");
		        
		      //  Bson filter=Filters.and(Filters.eq("countries","Spain"), Filters.gt("year",2014));
		        
		        collection.distinct("type",String.class).forEach(doc -> System.out.println("Movie mota:"+ doc.toString()));;
		      
		        
		    }
	}
	
	
	
}
