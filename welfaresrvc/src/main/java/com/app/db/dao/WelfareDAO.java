package com.app.db.dao;

import java.util.List;

import com.app.db.model.City;
import com.app.db.model.Country;
import com.app.db.model.State;
import com.app.db.model.Street;
import com.app.db.model.User;
import com.app.rest.vo.LoginDataVO;

/**
Time   : 1:42:00 pm
created: 24-Dec-2016
author : nitesh
**/

public interface WelfareDAO {

	public String createNewUser(User user);
	public User validateUserCredentials(LoginDataVO loginDataVO);
	public List<User> loadAllUserData();
	public List<Country> getCountryList();
	public List<State> getStateList(Long countryId);
	public List<City> getCityList(Long stateId);
	public List<Street> getStreetList(Long cityId);
}
