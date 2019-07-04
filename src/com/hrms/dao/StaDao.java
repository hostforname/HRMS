package com.hrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hrms.bean.Staff;
import com.hrms.util.DateBaseUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 
 * 列出区域列表
 * @return
 */
public class StaDao {
	DateBaseUtil dbutil;
	Connection conn=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	
	public StaDao(){
		dbutil=new DateBaseUtil();
	}
	
	
	/**
	 * addSta() - 向数据库中添加员工信息
	 * @param stana
	 * @param stase
	 * @param stade
	 * @param stawty
	 * @param staed
	 * @param stawtm
	 */
	public void addSta(String stana, String stase, String stade, 
			String stawty, String staed, String stawtm){
		String sql="insert into hrstaff(staffname,sex,department,worktype,education,worktime) values(?,?,?,?,?,?)";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, stana);
			pstat.setString(2, stase);
			pstat.setString(3, stade);
			pstat.setString(4, stawty);
			pstat.setString(5, staed);
			pstat.setString(6, stawtm);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}
	
	
	/**
	 * getStaff() - 查询数据库中所有员工信息
	 * @return - ArrayList<Staff> stas
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
	 * updateStaById() - 通过id来更新数据库中的员工信息
	 * @param staid
	 * @param stana
	 * @param stase
	 * @param stade
	 * @param stawty
	 * @param staed
	 * @param stawtm
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
	 * removeStaById(Integer id) - 根据ID移除员工信息
	 * @param staid
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
