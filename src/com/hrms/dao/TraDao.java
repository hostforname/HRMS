package com.hrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hrms.bean.Staff;
import com.hrms.bean.Train;
import com.hrms.util.DateBaseUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TraDao {
	DateBaseUtil dbutil;
	Connection conn=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	
	public TraDao(){
		dbutil=new DateBaseUtil();
	}
	
	/**
	 * addDep() - 用于新增部门信息
	 * @param depid
	 * @param dep
	 * @param depct
	 * @param depre
	 */
	public void addTra(String traer, String tratl, String tratm, 
			String traad, String tradi){
		String sql="insert into hrtrain(trainer,traintitle,traintime,trainaddr,detainfo) values(?,?,?,?,?)";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, traer);
			pstat.setString(2, tratl);
			pstat.setString(3, tratm);
			pstat.setString(4, traad);
			pstat.setString(5, tradi);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}
	
	/**
	 * getEmps() - 获取数据库表中所有员工信息
	 * @return - ArrayList<Emp> emps
	 */
	public ArrayList<Train> getTrain(){
		ArrayList<Train> tras=new ArrayList<Train>();
		Train tra=null;
		String sql="select * from hrtrain";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()){
				tra=new Train(rs.getInt("trainid"),rs.getString("trainer"),rs.getString("traintitle"),rs.getDate("traintime")
						,rs.getString("trainaddr"),rs.getString("detainfo"));
				tras.add(tra);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return tras;
	}
	/**
	 * updateStaById() - 用于修改部门信息
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
	 * removeDepById(Integer id) - 根据ID移除员工信息
	 * @param id
	 */
	public void removeTraById(Integer traid){
		String sql="delete from hrtrain where trainid=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, traid);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}

}