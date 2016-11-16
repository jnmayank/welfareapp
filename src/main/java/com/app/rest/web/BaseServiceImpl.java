package com.app.rest.web;

import org.springframework.stereotype.Service;
import com.app.rest.vo.AccountCreationResponseVO;
import com.app.rest.vo.PostCreatedSuccessfullVO;
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
	public String getCallTest() {
		System.out.println("userresponse");
		return "userresponse"+" = ";
	}

	@Override
	public WelfareVO<PostCreatedSuccessfullVO> feedNewPost(PostDataVO postDataVO) {
		// complete implementation
		return null;
	}

}
