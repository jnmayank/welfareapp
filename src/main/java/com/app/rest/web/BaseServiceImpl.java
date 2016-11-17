package com.app.rest.web;

import java.util.Date;

import org.springframework.stereotype.Service;
import com.app.rest.vo.AccountCreationResponseVO;
import com.app.rest.vo.BlogDataPostScrollVO;
import com.app.rest.vo.PostResponseVO;
import com.app.rest.vo.PostDataVO;
import com.app.rest.vo.UserWelfareAccountVO;
import com.app.rest.vo.WelfareVO;

/**
Time   : 12:53:28 am
created: 14-Nov-2016
author : nitesh
**/

@Service("baseService")
public class BaseServiceImpl implements BaseService{

	@Override
	public WelfareVO<AccountCreationResponseVO> registerNewUser(UserWelfareAccountVO userWelfareAccountVO) {
		AccountCreationResponseVO accountCreationResponseVO = new AccountCreationResponseVO();
		accountCreationResponseVO.setResultmessage("success");
		WelfareVO<AccountCreationResponseVO> response = new WelfareVO<AccountCreationResponseVO>(accountCreationResponseVO, false);
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
		// TODO Auto-generated method stub
		return null;
	}

}
