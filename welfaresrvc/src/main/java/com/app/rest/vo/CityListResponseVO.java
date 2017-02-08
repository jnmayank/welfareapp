package com.app.rest.vo;

import java.util.HashMap;

public class CityListResponseVO {
	private HashMap<Long, String> cityList;

	public HashMap<Long, String> getCityList() {
		return cityList;
	}

	public void setCityList(HashMap<Long, String> cityList) {
		this.cityList = cityList;
	}
}
