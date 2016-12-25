package com.app.sql.mgr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.db.dao.WelfareDAO;
import com.app.db.model.User;
import com.app.rest.vo.LoginDataVO;
import com.app.rest.vo.LoginResponseVO;
import com.app.rest.vo.UserWelfareAccountVO;

/**
Time   : 1:50:21 pm
created: 24-Dec-2016
author : nitesh
**/

@Component("hibernateTransMgr")
public class HibernateTransMgr {

	@Autowired
	private WelfareDAO welfareDAO;
	
	public String createNewUser(UserWelfareAccountVO userWelfareAccountVO){
		User user = new User();
		user.setName(userWelfareAccountVO.getUsername());
		user.setDateofbirth(userWelfareAccountVO.getDateOfBirth());
		user.setEmail(userWelfareAccountVO.getEmail());
		user.setPassword(userWelfareAccountVO.getPassword());
		return welfareDAO.createNewUser(user);
	}
	
	public LoginResponseVO validateUser(LoginDataVO loginDataVO){
		LoginResponseVO lvo = new LoginResponseVO();
		User userDetails = welfareDAO.validateUserCredentials(loginDataVO);
		if(null!=userDetails){
			lvo.setValidLogin(true);
			lvo.setUserId(userDetails.getId());
		}else{
			lvo.setUserId(-1);
			lvo.setValidLogin(false);
		}
		return lvo;
	}
	
	public List<UserWelfareAccountVO> getAllUserData(){
		List<UserWelfareAccountVO> result = new ArrayList<>();
		List<User> loadAllUserData = welfareDAO.loadAllUserData();
		for (Iterator iterator = loadAllUserData.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			UserWelfareAccountVO dataObject = new UserWelfareAccountVO();
			dataObject.setId(Integer.toString(user.getId()));
			dataObject.setEmail(user.getEmail());
			dataObject.setDateOfBirth(user.getDateofbirth());
			dataObject.setPassword(user.getPassword());
			dataObject.setUsername(user.getName());
			result.add(dataObject);
		}
		return result;
	}
}
