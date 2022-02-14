package eus.uni.dam.hiru;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


import eus.uni.dam.bi.Umea;

public class AppWithThreePojos {
	
	public static void main(String[] args) {
		 
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        // Replace the uri string with your MongoDB deployment's connection string
        String uri = "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        
        
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("gabonak").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Eskatzaileak> collection = database.getCollection("eskatzaileak", Eskatzaileak.class);
          
          // Umea ume = collection.find(eq("izena", "Pepa")).first();
          //System.out.println(ume);
            
          /*      
          Eskatzaileak esk1= collection.find().first();
          System.out.println(esk1);
          */
            
          /*
          Umea umeBerria= new Umea();
          umeBerria.setIzena("Pepe");
          InsertOneResult iResult = collection.insertOne(umeBerria);
          System.out.println("Txertatutako dokumentuaren id-a:"+iResult.getInsertedId());*/
            
          List<Oparia> oparitsuak = new ArrayList();
          oparitsuak.add(new Oparia("Ordenagailu sagua",1,new Emailea("Olentzero",54)));
          Eskatzaileak eskBerria = new Eskatzaileak("Asier",oparitsuak);
          collection.insertOne(eskBerria);
          
       
        
          
          
          List<Eskatzaileak> eska = new ArrayList();
          collection.find().into(eska);
          eska.forEach((esk -> System.out.println(esk)));
            
        }
    }
	
	
	

}
