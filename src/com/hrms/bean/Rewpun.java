package com.hrms.bean;

import java.util.Date;

public class Rewpun {
	//奖惩编号
	private Integer rewpunid;
	//奖惩主题
	private String rewpuntitle;
	//奖惩类型 1表示奖 0表示惩
	private Integer rewpuntype;
	//奖惩金额
	private Integer rewpunmount;
	//奖惩时间
	private Date rewpuntime;
	//详细信息
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
