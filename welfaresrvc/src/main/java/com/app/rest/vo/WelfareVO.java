package com.app.rest.vo;
/**
Time   : 12:57:33 am
created: 14-Nov-2016
author : nitesh
**/

public class WelfareVO<T> {
	private T object;
	private boolean error;
	private String errorMessage;
	
	public WelfareVO(T object, boolean error) {
		super();
		this.object = object;
		this.error = error;
	}
	public WelfareVO(boolean error, String errorMessage) {
		super();
		this.error = error;
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the object
	 */
	public T getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(T object) {
		this.object = object;
	}
	/**
	 * @return the error
	 */
	public boolean isError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(boolean error) {
		this.error = error;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
