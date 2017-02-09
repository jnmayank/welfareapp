package com.app.mongo.transact.mgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.grievance.model.Grievance;
import com.app.mongo.provider.MongoProvider;
import com.google.gson.JsonObject;

@Repository
public class MongoTransactMgr {

	@Autowired
	private MongoProvider mongoProvider;
	
	public boolean insertGrievanceDataInMongo(JsonObject jsonObject){
		
		return false;
	}

}
