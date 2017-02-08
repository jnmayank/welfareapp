package com.app.rest.vo;

import java.util.HashMap;

public class StreetListResponseVO {
	private HashMap<Long,String> streetList;

	public HashMap<Long, String> getStreetList() {
		return streetList;
	}

	public void setStreetList(HashMap<Long, String> streetList) {
		this.streetList = streetList;
	}
}
