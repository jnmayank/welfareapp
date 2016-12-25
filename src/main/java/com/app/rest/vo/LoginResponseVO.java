package com.app.rest.vo;

public class LoginResponseVO {

	private boolean validLogin;
	private int userId;

	public boolean isValidLogin() {
		return validLogin;
	}

	public void setValidLogin(boolean validLogin) {
		this.validLogin = validLogin;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
