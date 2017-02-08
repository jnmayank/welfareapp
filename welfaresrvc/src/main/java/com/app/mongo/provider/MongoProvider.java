package com.app.mongo.provider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

@Service
public class MongoProvider {
	
	@Autowired
	private MongoClient mongoClient;
	
	private static MongoDatabase db = null;
	
	
	public MongoDatabase getDb(){
		if(db==null){
			db = mongoClient.getDatabase("myfmongo");
		}else{
			return db;
		}
		return db;
	}
}
