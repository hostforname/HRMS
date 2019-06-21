package com.hrms.bean;

import java.util.Date;

public class Train {
	//编号
	private Integer trainid;
	//培训人
	private String trainer;
	//培训时间
	private Date traintime;
	//培训地点
	private String trainaddr;
	//详细信息
	private String detainfo;
	
	public Train(Integer trainid, String trainer, Date traintime, String trainaddr, String detainfo) {
		super();
		this.trainid = trainid;
		this.trainer = trainer;
		this.traintime = traintime;
		this.trainaddr = trainaddr;
		this.detainfo = detainfo;
	}
	public Integer getTrainid() {
		return trainid;
	}
	public String getTrainer() {
		return trainer;
	}
	public Date getTraintime() {
		return traintime;
	}
	public String getTrainaddr() {
		return trainaddr;
	}
	public String getDetainfo() {
		return detainfo;
	}
	
	
}
