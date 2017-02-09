package com.app.mongo.transact.mgr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.mongo.provider.MongoProvider;
import com.google.gson.JsonObject;
import com.mongodb.MongoException;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@Repository
public class MongoTransactMgr {

	@Autowired
	private MongoProvider mongoProvider;

	public boolean insertGrievanceDataInMongo(JsonObject jsonObject) {

		try {
			String json = jsonObject.toString();
			MongoDatabase db = mongoProvider.getDb();
			MongoCollection<Document> collection = db.getCollection("grievancecollect");
			Document document = Document.parse(json);
			collection.insertOne(document);
		} catch (Exception e) {
			throw new MongoException("Error in inserting document", e);
		}
		return true;
	}
	
	public List<String> getListOfStatesFromMongoServer(){
		MongoDatabase db = mongoProvider.getDb();
		MongoCollection<Document> collection = db.getCollection("grievancecollect");
		List<String> result = new ArrayList<String>();
		Consumer<String> dc = elem->result.add(elem);
		DistinctIterable<String> distinct = collection.distinct("state",String.class);
		distinct.forEach(dc);
		return result;
	}
	
	public List<String> getListOfDepartmentMongoServer(){
		MongoDatabase db = mongoProvider.getDb();
		MongoCollection<Document> collection = db.getCollection("grievancecollect");
		List<String> result = new ArrayList<String>();
		Consumer<String> dc = elem->result.add(elem);
		DistinctIterable<String> distinct = collection.distinct("departMent",String.class);
		distinct.forEach(dc);
		return result;
	}

}
