package com.hrms.bean;

public class Recruit {
	//���
	private Integer recruitid;
	//����
	private String name;
	//�Ա�
	private String sex;
	//ӦƸְλ
	private String recruittype;
	//ѧ��
	private String education;
	//��������
	private String workexp;
	//��ϸ��Ϣ
	private String detainfo;
	//ӦƸ״̬	0��δ¼��	1����¼��
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
