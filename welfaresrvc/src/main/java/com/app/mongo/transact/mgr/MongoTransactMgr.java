package com.app.mongo.transact.mgr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Consumer;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.mongo.provider.MongoProvider;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCollection;
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

	public List<String> getListOfStatesFromMongoServer() {
		MongoDatabase db = mongoProvider.getDb();
		MongoCollection<Document> collection = db.getCollection("grievancecollect");
		List<String> result = new ArrayList<String>();
		Consumer<String> dc = elem -> result.add(elem);
		DistinctIterable<String> distinct = collection.distinct("state", String.class);
		distinct.forEach(dc);
		return result;
	}

	public List<String> getListOfDepartmentMongoServer() {
		MongoDatabase db = mongoProvider.getDb();
		MongoCollection<Document> collection = db.getCollection("grievancecollect");
		List<String> result = new ArrayList<String>();
		Consumer<String> dc = elem -> result.add(elem);
		DistinctIterable<String> distinct = collection.distinct("departMent", String.class);
		distinct.forEach(dc);
		return result;
	}

	public CountResponseC3 getDistinctCountsByStateaDepartment() {
		MongoDatabase db = mongoProvider.getDb();
		MongoCollection<Document> collection = db.getCollection("grievancecollect");
		List<String> result = new ArrayList<String>();
		Consumer<String> dc = elem -> result.add(elem);
		DistinctIterable<String> distinct = collection.distinct("state", String.class);
		distinct.forEach(dc);
		List<String> departments = getListOfDepartmentMongoServer();

		HashMap<String, Map<String, Long>> resultMap = new HashMap<>();
		for (String stateName : result) {
			resultMap.putIfAbsent(stateName, new HashMap<String, Long>());
			for (String departMent : departments) {
				BasicDBObject query = new BasicDBObject("state", stateName);
				query.append("departMent", departMent);
				long count = collection.count(query);
				// if (count > 0)
				resultMap.get(stateName).put(departMent, count);
				// System.out.println("stateName: "+stateName+", departMent
				// :"+departMent+", Count: "+count);
			}
		}
		
		System.out.println(resultMap);
		
		Set<String> keyOfMap = resultMap.keySet();
		Map<Integer,String> stateMap = new HashMap<>();
		int i = 0;
		TreeMap<String,List<Long>> departCount = new TreeMap<>();
		for(String key:keyOfMap){
			Map<String, Long> departmentMap = resultMap.get(key);
			stateMap.put(i++, key);
			Set<String> departSet = departmentMap.keySet();
			for(String departMent:departSet){
				departCount.putIfAbsent(departMent, new ArrayList<>());
				departCount.get(departMent).add(departmentMap.get(departMent));
			}
		}
		
		CountResponseC3 c3response = new CountResponseC3();
		c3response.setDepartCount(departCount);
		c3response.setStateMap(stateMap);
		return c3response;
	}
}
