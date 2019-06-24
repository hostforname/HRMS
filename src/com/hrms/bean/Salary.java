package com.hrms.bean;

import java.util.Date;

public class Salary {
	//员工编号
	private Integer staffid;
	//员工姓名
	private String staffname;
	//当前月份
	private String curmonth;
	//基本工资
	private Integer basepay;
	//加班费
	private Integer overtimepay;
	//工龄费
	private Integer duration;
	//考勤费
	private Integer attpay;
	//旷工费
	private Integer abspay;
	//保险费
	private Integer inspay;
	
	
	public Salary(Integer staffid, String staffname,String curmonth, Integer basepay, Integer overtimepay, Integer duration,
			Integer attpay, Integer abspay, Integer inspay) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
		this.curmonth = curmonth;
		this.basepay = basepay;
		this.overtimepay = overtimepay;
		this.duration = duration;
		this.attpay = attpay;
		this.abspay = abspay;
		this.inspay = inspay;
	}
	public Integer getStaffid() {
		return staffid;
	}
	public String getStaffname() {
		return staffname;
	}	
	public String getCurmonth() {
		return curmonth;
	}
	public Integer getBasepay() {
		return basepay;
	}
	public Integer getOvertimepay() {
		return overtimepay;
	}
	public Integer getDuration() {
		return duration;
	}
	public Integer getAttpay() {
		return attpay;
	}
	public Integer getAbspay() {
		return abspay;
	}
	public Integer getInspay() {
		return inspay;
	}
	
}
