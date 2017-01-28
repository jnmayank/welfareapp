package com.app.rest.vo;

import java.util.HashMap;

public class StateListResponseVO {
	private HashMap<Long, String> stateList;

	public HashMap<Long, String> getStateList() {
		return stateList;
	}

	public void setStateList(HashMap<Long, String> stateList) {
		this.stateList = stateList;
	}
}
