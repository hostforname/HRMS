package com.hrms.bean;

public class User {
	//�û����
	private Integer userid;
	//�û���
	private String username;
	//�û�����
	private String userpwd;

	public User(Integer userid, String username, String userpwd) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
	}
	
	public Integer getUserid() {
		return userid;
	}
	public String getUsername() {
		return username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	
	
}
