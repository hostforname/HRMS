package com.hrms.bean;

import java.util.Date;

public class Rewpun {
	//���ͱ��
	private Integer rewpunid;
	//��������
	private String rewpuntitle;
	//�������� 1��ʾ�� 0��ʾ��
	private Integer rewpuntype;
	//���ͽ��
	private Integer rewpunmount;
	//����ʱ��
	private Date rewpuntime;
	//��ϸ��Ϣ
	private String detainfo;
	
	public Rewpun(Integer rewpunid, String rewpuntitle, Integer rewpuntype, Integer rewpunmount, Date rewpuntime,
			String detainfo) {
		super();
		this.rewpunid = rewpunid;
		this.rewpuntitle = rewpuntitle;
		this.rewpuntype = rewpuntype;
		this.rewpunmount = rewpunmount;
		this.rewpuntime = rewpuntime;
		this.detainfo = detainfo;
	}
	public Integer getRewpunid() {
		return rewpunid;
	}
	public String getRewpuntitle() {
		return rewpuntitle;
	}
	public Integer getRewpuntype() {
		return rewpuntype;
	}
	public Integer getRewpunmount() {
		return rewpunmount;
	}
	public Date getRewpuntime() {
		return rewpuntime;
	}
	public String getDetainfo() {
		return detainfo;
	}
	
}
