package com.app.rest.vo;

import java.util.Date;

/**
Time   : 11:43:37 pm
created: 16-Nov-2016
author : nitesh
**/

public class PostResponseVO {
	private String postData;
	private Date postCreationDate;
	private String postId;
	
	public String getPostData() {
		return postData;
	}
	public void setPostData(String postData) {
		this.postData = postData;
	}
	public Date getPostCreationDate() {
		return postCreationDate;
	}
	public void setPostCreationDate(Date postCreationDate) {
		this.postCreationDate = postCreationDate;
	}
	
	/**
	 * @return the postId
	 */
	public String getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(String postId) {
		this.postId = postId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postCreationDate == null) ? 0 : postCreationDate.hashCode());
		result = prime * result + ((postData == null) ? 0 : postData.hashCode());
		result = prime * result + ((postId == null) ? 0 : postId.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PostResponseVO)) {
			return false;
		}
		PostResponseVO other = (PostResponseVO) obj;
		if (postCreationDate == null) {
			if (other.postCreationDate != null) {
				return false;
			}
		} else if (!postCreationDate.equals(other.postCreationDate)) {
			return false;
		}
		if (postData == null) {
			if (other.postData != null) {
				return false;
			}
		} else if (!postData.equals(other.postData)) {
			return false;
		}
		if (postId == null) {
			if (other.postId != null) {
				return false;
			}
		} else if (!postId.equals(other.postId)) {
			return false;
		}
		return true;
	}
	
}
