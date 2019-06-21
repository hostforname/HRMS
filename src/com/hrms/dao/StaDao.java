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
	public void addDep(Integer depid, String dep, String depct, 
			String depre){
		String sql="insert into hrStaff values(?,?,?,?)";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, depid);
			pstat.setString(2, dep);
			pstat.setString(3, depct);
			pstat.setString(4, depre);
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
	public void updateStaById(Integer staid, String stana, String stase, String stade, String stawty, String staed, String stawtm) {
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
	public void removeDepById(Integer depid){
		String sql="delete from hrStaff where Staffid=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, depid);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}

}
