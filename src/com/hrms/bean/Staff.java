package com.hrms.bean;

import java.util.Date;

public class Staff {
	//Ա�����
	private Integer staffid;
	//Ա������
	private String staffname;
	//�Ա�
	private String sex;
	//����
	private String departmeng;
	//����
	private String worktype;
	//ѧ��
	private String education;
	//����ʱ��
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
