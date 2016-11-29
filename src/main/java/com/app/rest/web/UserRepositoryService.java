package com.app.rest.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Component;

import com.app.rest.vo.LoginDataVO;

import app.elastic.repo.UserRepository;
import app.elastic.repo.UserWelfareAccountVO;

/**
 * Time : 1:15:39 am created: 25-Nov-2016 author : nitesh
 **/

@Component("userRepositoryService")
public class UserRepositoryService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	public void findAllUser() {
		userRepository.findAll().forEach(System.out::println);
	}

	public List<UserWelfareAccountVO> findUser(String username) {
		List<UserWelfareAccountVO> userList = userRepository
				.findUserByUsername(username);
		System.out.println("User list: " + userList);
		return userList;
	}

	public List<UserWelfareAccountVO> findUserByDateOfBirth(Date dateOfBirth) {
		List<UserWelfareAccountVO> userList = userRepository
				.findUserByDateOfBirth(dateOfBirth);
		return userList;
	}

	public String createUser(UserWelfareAccountVO userWelfareAccountVO) {

		try {
			elasticsearchTemplate.putMapping(UserWelfareAccountVO.class);
			IndexQuery idxQuery = new IndexQuery();
			idxQuery.setId(userWelfareAccountVO.getId());
			idxQuery.setObject(userWelfareAccountVO);
			elasticsearchTemplate.index(idxQuery);
			elasticsearchTemplate.refresh(UserWelfareAccountVO.class, true);
			return "success";
		} catch (Exception e) {
			System.err.println("Exception in creation of User "
					+ e.getStackTrace());
		}
		return null;
	}

	public boolean validateLoginCredentials(LoginDataVO loginDataVO) {
		List<UserWelfareAccountVO> findUser = findUser(loginDataVO
				.getUserName());
		for (UserWelfareAccountVO userWelfareAccountVO : findUser) {
			if (userWelfareAccountVO.getPassword().equals(
					loginDataVO.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
