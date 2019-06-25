package com.hrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hrms.bean.Rewpun;
import com.hrms.util.DateBaseUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class RewDao {
	DateBaseUtil dbutil;
	Connection conn=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	
	public RewDao(){
		dbutil=new DateBaseUtil();
	}
	
	/**
	 * addDep() - ��������������Ϣ
	 * @param depid
	 * @param dep
	 * @param depct
	 * @param depre
	 */
	public void addRew(String rewtl, Integer rewty, Integer rewmo, 
			String rewdi){
		String sql="insert into hrrewpun(rewpuntitle,rewpuntype,rewpunmount,detainfo) values(?,?,?,?)";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, rewtl);
			pstat.setInt(2, rewty);
			pstat.setInt(3, rewmo);
			pstat.setString(4, rewdi);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}
	
	/**
	 * getEmps() - ��ȡ���ݿ��������Ա����Ϣ
	 * @return - ArrayList<Emp> emps
	 */
	public ArrayList<Rewpun> getRewpun(){
		ArrayList<Rewpun> rews=new ArrayList<Rewpun>();
		Rewpun rew=null;
		String sql="select * from hrrewpun";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()){
				rew=new Rewpun(rs.getInt("rewpunid"),rs.getString("rewpuntitle"),rs.getInt("rewpuntype"),rs.getInt("rewpunmount")
						,rs.getDate("rewpuntime"),rs.getString("detainfo"));
				rews.add(rew);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat,rs);
		}
		return rews;
	}
	/**
	 * updateStaById() - �����޸Ĳ�����Ϣ
	 * @param staid
	 * @param stana
	 * @param stase
	 * @param stade
	 * @param stawtm 
	 * @param staed 
	 * @param stawty 
	 */
	/*
	public void updateStaById(Integer staid, String stana, String stase, String stade, 
			String stawty, String staed, String stawtm) {
		String sql="update hrstaff set staffname=?,sex=?,department=?,worktype=?,education=?,worktime=? where staffid=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, stana);
			pstat.setString(2, stase);
			pstat.setString(3, stade);
			pstat.setString(4, stawty);
			pstat.setString(5, staed);
			pstat.setString(6, stawtm);
			pstat.setInt(7, staid);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}		
	}
	 */
	/**
	 * removeDepById(Integer id) - ����ID�Ƴ�Ա����Ϣ
	 * @param id
	 */
	public void removeRewById(Integer rewid){
		String sql="delete from hrrewpun where rewpunid=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, rewid);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}

}