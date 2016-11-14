package com.app.rest.web;

import org.springframework.stereotype.Service;
import com.app.rest.vo.AccountCreationResponseVO;
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
		System.out.println("userresponse");
		return null;
	}

	@Override
	public String getCallTest(String data) {
		System.out.println("userresponse");
		return "userresponse"+" = "+data;
	}

}
