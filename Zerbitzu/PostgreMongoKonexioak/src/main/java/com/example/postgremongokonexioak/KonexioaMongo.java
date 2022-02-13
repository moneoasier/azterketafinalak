package com.example.postgremongokonexioak;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.example.postgremongokonexioak.model.Puntuazioa;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class KonexioaMongo extends Thread{
	
	public int insertPuntuazioa(ArrayList<Puntuazioa> puntuazioak) {
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
		
		String uri = "mongodb://192.168.65.2:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
		
		try (MongoClient mongoClient = MongoClients.create(uri)) {
			MongoDatabase database = mongoClient.getDatabase("naaahi").withCodecRegistry(pojoCodecRegistry);
			MongoCollection<Puntuazioa> collection = database.getCollection("puntuazioa", Puntuazioa.class);
			System.out.println("Konektatuta Mongora");
			
			collection.insertMany(puntuazioak);
			return 1;
		}catch (Exception e) {
			return 0;
		}
	}
}
