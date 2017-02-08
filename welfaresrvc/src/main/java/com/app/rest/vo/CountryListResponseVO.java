package com.app.rest.vo;

import java.util.HashMap;

public class CountryListResponseVO {
	private HashMap<Long, String> countryList;

	public HashMap<Long, String> getCountryList() {
		return countryList;
	}

	public void setCountryList(HashMap<Long, String> countryList) {
		this.countryList = countryList;
	}
}
