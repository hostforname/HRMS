package com.hrms.bean;

import java.util.Date;

public class Staff {
	//员工编号
	private Integer staffid;
	//员工姓名
	private String staffname;
	//性别
	private String sex;
	//部门
	private String departmeng;
	//工种
	private String worktype;
	//学历
	private String education;
	//工作时间
	private Date worktime;
	
	
	public Staff(Integer staffid, String staffname, String sex, String departmeng, String worktype, String education,
			Date worktime) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
		this.sex = sex;
		this.departmeng = departmeng;
		this.worktype = worktype;
		this.education = education;
		this.worktime = worktime;
	}
	
	public Integer getStaffid() {
		return staffid;
	}
	
	public String getStaffname() {
		return staffname;
	}
	
	public String getSex() {
		return sex;
	}
	
	public String getDepartmeng() {
		return departmeng;
	}
	
	public String getWorktype() {
		return worktype;
	}
	
	public String getEducation() {
		return education;
	}
	public Date getWorktime() {
		return worktime;
	}
}
