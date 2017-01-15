package com.app.db.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.db.model.User;
import com.app.rest.vo.LoginDataVO;

/**
 * Time : 1:42:20 pm created: 24-Dec-2016 author : nitesh
 **/

@Transactional
@Repository("welfareDAO")
public class WelfareDAOImpl implements WelfareDAO {

	@Autowired
	private SessionFactory hbnsessionFactory;

	@Override
	public String createNewUser(User user) {
		Session currentSession = hbnsessionFactory.getCurrentSession();
		currentSession.beginTransaction();
		Serializable save = currentSession.save(user);
		/*
		 * if(currentSession.getTransaction().getStatus().)
		 * currentSession.getTransaction().commit();
		 */
		return "success";
	}

	@Override
	public User validateUserCredentials(LoginDataVO loginDataVO) {
		Session currentSession = hbnsessionFactory.getCurrentSession();
		currentSession.beginTransaction();
		Query query = currentSession.createQuery("from User where name=:name and password=:password");
		query.setString("name", loginDataVO.getUserName());
		query.setString("password", new String(loginDataVO.getPassword()));
		List<User> list = query.list();
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public List<User> loadAllUserData(){
		Session currentSession = hbnsessionFactory.getCurrentSession();
		currentSession.beginTransaction();
		Query query = currentSession.createQuery("from User");
		return query.list();
	}

}
