package com.hrms.bean;

import java.util.Date;

public class Department {
	//员工编号
	private Integer departmentid;
	//部门名
	private String department;
	//创建时间
	private Date createtime;
	//备注
	private String remarks;
	
	public Department(Integer departmentid, String department, Date createtime, String remarks) {
		super();
		this.departmentid = departmentid;
		this.department = department;
		this.createtime = createtime;
		this.remarks = remarks;
	}

	public Integer getDepartmentid() {
		return departmentid;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public Date getCreatetime() {
		return createtime;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
}
