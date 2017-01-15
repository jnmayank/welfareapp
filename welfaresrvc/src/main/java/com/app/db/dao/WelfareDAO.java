package com.app.db.dao;

import java.util.List;

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
}
