package com.hrms.bean;

import java.util.Date;

public class Department {
	//Ա�����
	private Integer departmentid;
	//������
	private String department;
	//����ʱ��
	private Date createtime;
	//��ע
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
