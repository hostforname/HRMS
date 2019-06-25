package com.hrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.hrms.bean.Staff;
import com.hrms.util.DateBaseUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class StaDao {
	DateBaseUtil dbutil;
	Connection conn=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	
	public StaDao(){
		dbutil=new DateBaseUtil();
	}
	
	/**
	 * addDep() - ��������������Ϣ
	 * @param depid
	 * @param dep
	 * @param depct
	 * @param depre
	 */
	public void addSta(Integer staid, String stana, String stase, String stade, 
			String stawty, String staed, String stawtm){
		String sql="insert into hrstaff values(?,?,?,?,?,?,?)";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, staid);
			pstat.setString(2, stana);
			pstat.setString(3, stase);
			pstat.setString(4, stade);
			pstat.setString(5, stawty);
			pstat.setString(6, staed);
			pstat.setString(7, stawtm);
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
	public ArrayList<Staff> getStaff(){
		ArrayList<Staff> stas=new ArrayList<Staff>();
		Staff sta=null;
		String sql="select * from hrstaff";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()){
				sta=new Staff(rs.getInt("staffid"),rs.getString("staffname"),rs.getString("sex"),rs.getString("department")
						,rs.getString("worktype"),rs.getString("education"),rs.getDate("worktime"));
				stas.add(sta);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat,rs);
		}
		return stas;
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

	/**
	 * removeDepById(Integer id) - ����ID�Ƴ�Ա����Ϣ
	 * @param id
	 */
	public void removeStaById(Integer staid){
		String sql="delete from hrstaff where staffid=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, staid);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}

}
