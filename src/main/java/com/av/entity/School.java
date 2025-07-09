package com.av.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class School {
	
	@Id
	private int studId;
	private String studName;
	private int tId;
	private String tName;
	public School() {
	
	}
	public School(int studId, String studName, int tId, String tName) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.tId = tId;
		this.tName = tName;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	@Override
	public String toString() {
		return "School [studId=" + studId + ", studName=" + studName + ", tId=" + tId + ", tName=" + tName + "]";
	}
	
	
	

}
