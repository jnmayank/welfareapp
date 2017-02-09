package com.app.grievance.model;

public class Grievance {
	
	private String state;
	private String departMent;
	private boolean isNewState;
	private boolean isNewDepartment;
	private Long amount;
	private String incident;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDepartMent() {
		return departMent;
	}
	public void setDepartMent(String departMent) {
		this.departMent = departMent;
	}
	public boolean isNewState() {
		return isNewState;
	}
	public void setNewState(boolean isNewState) {
		this.isNewState = isNewState;
	}
	public boolean isNewDepartment() {
		return isNewDepartment;
	}
	public void setNewDepartment(boolean isNewDepartment) {
		this.isNewDepartment = isNewDepartment;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getIncident() {
		return incident;
	}
	public void setIncident(String incident) {
		this.incident = incident;
	}
}
