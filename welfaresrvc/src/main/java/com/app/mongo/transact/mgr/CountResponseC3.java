package com.app.mongo.transact.mgr;

import java.util.List;
import java.util.Map;

public class CountResponseC3 {

	private Map<String,List<Long>> departCount;
	private Map<Integer,String> stateMap;
	/**
	 * @return the departCount
	 */
	public Map<String, List<Long>> getDepartCount() {
		return departCount;
	}
	/**
	 * @param departCount the departCount to set
	 */
	public void setDepartCount(Map<String, List<Long>> departCount) {
		this.departCount = departCount;
	}
	/**
	 * @return the stateMap
	 */
	public Map<Integer, String> getStateMap() {
		return stateMap;
	}
	/**
	 * @param stateMap the stateMap to set
	 */
	public void setStateMap(Map<Integer, String> stateMap) {
		this.stateMap = stateMap;
	}
	
	
}
