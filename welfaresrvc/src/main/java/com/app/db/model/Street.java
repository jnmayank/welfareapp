package com.app.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "street")
public class Street {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="streetId")
	private int streetId;
	
	@Column(name="streetName")
	private String streetName;
	
	@ManyToOne
	@JoinColumn(name="cityId",nullable=false)
	private City city;
	
	public int getStreetId() {
		return streetId;
	}

	public void setStreetId(int streetId) {
		this.streetId = streetId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
}
