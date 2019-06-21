package com.hrms.bean;

import java.util.Date;

public class Staff {
	private Integer staffid;
	private String staffname;
	private String sex;
	private String departmeng;
	private String worktype;
	private String education;
	private Date worktime;
	public Integer getStaffid() {
		return staffid;
	}
	public void setStaffid(Integer staffid) {
		this.staffid = staffid;
	}
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartmeng() {
		return departmeng;
	}
	public void setDepartmeng(String departmeng) {
		this.departmeng = departmeng;
	}
	public String getWorktype() {
		return worktype;
	}
	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Date getWorktime() {
		return worktime;
	}
	public void setWorktime(Date worktime) {
		this.worktime = worktime;
	}
	
	
}
