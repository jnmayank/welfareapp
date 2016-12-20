package com.app.rest.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rest.vo.AccountCreationResponseVO;
import com.app.rest.vo.BlogDataPostScrollVO;
import com.app.rest.vo.LoginDataVO;
import com.app.rest.vo.LoginResponseVO;
import com.app.rest.vo.PostDataVO;
import com.app.rest.vo.PostResponseVO;
import com.app.rest.vo.UserListResponseVO;
import com.app.rest.vo.WelfareVO;

import app.elastic.repo.UserWelfareAccountVO;

/**
 * Time : 12:53:28 am created: 14-Nov-2016 author : nitesh
 **/

@Service("baseService")
public class BaseServiceImpl implements BaseService {

	@Autowired
	private UserRepositoryService userRepositoryService;

	@Override
	public WelfareVO<AccountCreationResponseVO> registerNewUser(UserWelfareAccountVO userWelfareAccountVO) {
		AccountCreationResponseVO accountCreationResponseVO = new AccountCreationResponseVO();
		accountCreationResponseVO.setResultmessage("success");
		String responseMessage = userRepositoryService.createUser(userWelfareAccountVO);
		accountCreationResponseVO.setResultmessage(responseMessage);
		WelfareVO<AccountCreationResponseVO> response = new WelfareVO<AccountCreationResponseVO>(
				accountCreationResponseVO, false);
		return response;
	}

	@Override
	public WelfareVO<PostResponseVO> feedNewPost(PostDataVO postDataVO) {
		// complete implementation
		PostResponseVO pvo = new PostResponseVO();
		pvo.setPostCreationDate(new Date());
		pvo.setPostData(postDataVO.getPostData());
		WelfareVO<PostResponseVO> response = new WelfareVO<PostResponseVO>(pvo, false);
		return response;
	}

	@Override
	public WelfareVO<BlogDataPostScrollVO> getPostScroll(String after) {
		BlogDataPostScrollVO bvo = new BlogDataPostScrollVO();
		List<PostResponseVO> postDataList = new ArrayList<>();
		bvo.setPostDataList(postDataList);

		Integer data = Integer.parseInt(after);
		for (int i = 0; i < 9; i++) {
			PostResponseVO pvo = new PostResponseVO();
			pvo.setPostData("postdata" + (data + i));
			pvo.setPostCreationDate(new Date());
			postDataList.add(pvo);
		}
		WelfareVO<BlogDataPostScrollVO> wvoResponse = new WelfareVO<BlogDataPostScrollVO>(bvo, false);
		return wvoResponse;
	}

	@Override
	public WelfareVO<UserListResponseVO> getAllAccountData() {
		List<UserWelfareAccountVO> userDataList = userRepositoryService.findAllUser();
		UserListResponseVO resp = new UserListResponseVO();
		WelfareVO<UserListResponseVO> wresp = new WelfareVO<UserListResponseVO>(resp, false);
		return wresp;
	}

	@Override
	public WelfareVO<LoginResponseVO> doLogin(LoginDataVO loginDataVO) {
		boolean validateLoginCredentials = userRepositoryService.validateLoginCredentials(loginDataVO);
		LoginResponseVO loginResponseVO = new LoginResponseVO();
		loginResponseVO.setValidLogin(validateLoginCredentials);
		WelfareVO<LoginResponseVO> response = new WelfareVO<LoginResponseVO>(loginResponseVO, false);
		return response;
	}

	
	
}
