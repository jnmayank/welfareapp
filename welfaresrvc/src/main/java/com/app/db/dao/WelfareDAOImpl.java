package com.app.db.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.db.model.City;
import com.app.db.model.Country;
import com.app.db.model.State;
import com.app.db.model.Street;
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

	@Override
	public List<Country> getCountryList() {
		Session currentSession = hbnsessionFactory.getCurrentSession();
		currentSession.beginTransaction();
		Query query = currentSession.createQuery("from Country");
		return query.list();
	}

	@Override
	public List<State> getStateList(Long countryId) {
		Session currentSession = hbnsessionFactory.getCurrentSession();
		currentSession.beginTransaction();
		Query query = currentSession.createQuery("from State s where s.country= :countryId");
		query.setLong("countryId", countryId);
		return query.list();
	}

	@Override
	public List<City> getCityList(Long stateId) {
		Session currentSession = hbnsessionFactory.getCurrentSession();
		currentSession.beginTransaction();
		Query query = currentSession.createQuery("from City s where s.state= :stateId");
		query.setLong("stateId", stateId);
		return query.list();
	}

	@Override
	public List<Street> getStreetList(Long cityId) {
		Session currentSession = hbnsessionFactory.getCurrentSession();
		currentSession.beginTransaction();
		Query query = currentSession.createQuery("from Street s where s.city= :cityId");
		query.setLong("cityId", cityId);
		return query.list();
	}
	
}
