package com.hrms.bean;

import java.util.Date;

public class Train {
	//���
	private Integer trainid;
	//��ѵ��
	private String trainer;
	//��ѵ����
	private String traintitle;
	//��ѵʱ��
	private Date traintime;
	//��ѵ�ص�
	private String trainaddr;
	//��ϸ��Ϣ
	private String detainfo;
	
	public Train(Integer trainid, String trainer, String traintitle, Date traintime, String trainaddr, String detainfo) {
		super();
		this.trainid = trainid;
		this.trainer = trainer;
		this.traintitle = traintitle;
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
	public String getTraintitle() {
		return traintitle;
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
