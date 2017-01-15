package com.app.rest.vo;

import java.util.List;

/**
Time   : 11:01:18 pm
created: 20-Dec-2016
author : nitesh
**/

public class UserListResponseVO {
	List<UserWelfareAccountVO> userWelfareAccountVOList;

	/**
	 * @return the userWelfareAccountVOList
	 */
	public List<UserWelfareAccountVO> getUserWelfareAccountVOList() {
		return userWelfareAccountVOList;
	}

	/**
	 * @param userWelfareAccountVOList the userWelfareAccountVOList to set
	 */
	public void setUserWelfareAccountVOList(List<UserWelfareAccountVO> userWelfareAccountVOList) {
		this.userWelfareAccountVOList = userWelfareAccountVOList;
	}
	
}
