package com.hrms.bean;

public class Salary {
	//Ա�����
	private Integer staffid;
	//Ա������
	private String staffname;
	//��������
	private Integer basepay;
	//�Ӱ��
	private Integer overtimepay;
	//�����
	private Integer duration;
	//���ڷ�
	private Integer attpay;
	//������
	private Integer abspay;
	//���շ�
	private Integer inspay;
	
	
	public Salary(Integer staffid, String staffname, Integer basepay, Integer overtimepay, Integer duration,
			Integer attpay, Integer abspay, Integer inspay) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
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
