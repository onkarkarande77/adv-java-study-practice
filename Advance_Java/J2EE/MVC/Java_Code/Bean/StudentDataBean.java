package com.bean;

public class StudentDataBean {
	private String stdId;
	private String stdName;
	
	public StudentDataBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDataBean(String stdId, String stdName) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	@Override
	public String toString() {
		return "StudentDataBean [stdId=" + stdId + ", stdName=" + stdName + "]";
	}
	

}
