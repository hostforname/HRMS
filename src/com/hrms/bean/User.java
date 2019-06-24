package com.hrms.bean;

public class User {
	//用户序号
	private Integer userid;
	//用户名
	private String username;
	//用户密码
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
