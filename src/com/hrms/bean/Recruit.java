package com.hrms.bean;

public class Recruit {
	//编号
	private Integer recruitid;
	//姓名
	private String name;
	//性别
	private String sex;
	//应聘职位
	private String recruittype;
	//学历
	private String education;
	//工作经验
	private String workexp;
	//详细信息
	private String detainfo;
	//应聘状态	0：未录用	1：已录用
	private Integer status;
	
	
	public Recruit(Integer recruitid, String name, String sex, String recruittype, String education, String workexp,
			String detainfo,Integer status) {
		super();
		this.recruitid = recruitid;
		this.name = name;
		this.sex = sex;
		this.recruittype = recruittype;
		this.education = education;
		this.workexp = workexp;
		this.detainfo = detainfo;
		this.status = status;
	}
	public Integer getRecruitid() {
		return recruitid;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getRecruittype() {
		return recruittype;
	}
	public String getEducation() {
		return education;
	}
	public String getWorkexp() {
		return workexp;
	}
	public String getDetainfo() {
		return detainfo;
	}
	public Integer getStatus() {
		return status;
	}	
}
