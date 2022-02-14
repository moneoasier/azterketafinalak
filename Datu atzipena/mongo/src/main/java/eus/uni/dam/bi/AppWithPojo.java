package eus.uni.dam.bi;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.lang.UsesSunMisc;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

public class AppWithPojo {
	 public static void main(String[] args) {
		 
	        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
	        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
	        // Replace the uri string with your MongoDB deployment's connection string
	        String uri = "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
	        
	        
	        try (MongoClient mongoClient = MongoClients.create(uri)) {
	            MongoDatabase database = mongoClient.getDatabase("gabonak").withCodecRegistry(pojoCodecRegistry);
	            MongoCollection<Umea> collection = database.getCollection("umeak", Umea.class);
	          
	           // Umea ume = collection.find(eq("izena", "Pepa")).first();
	            //System.out.println(ume);
	            
	            
	          
	            
	           
	          Umea umeBerria= new Umea();
	          umeBerria.setIzena("Pepe");
	          InsertOneResult iResult = collection.insertOne(umeBerria);
	          System.out.println("Txertatutako dokumentuaren id-a:"+iResult.getInsertedId());
	            
	              List<Umea> umek = new ArrayList();
	            collection.find().into(umek);
	            umek.forEach((umi -> System.out.println(umi)));
	            
	        }
	    }
	}
