package com.app.rest.vo;

import java.util.List;

/**
Time   : 1:33:39 am
created: 17-Nov-2016
author : nitesh
**/

public class BlogDataPostScrollVO {
	private List<PostResponseVO> postDataList;

	/**
	 * @return the postDataList
	 */
	public List<PostResponseVO> getPostDataList() {
		return postDataList;
	}

	/**
	 * @param postDataList the postDataList to set
	 */
	public void setPostDataList(List<PostResponseVO> postDataList) {
		this.postDataList = postDataList;
	}
	
}
