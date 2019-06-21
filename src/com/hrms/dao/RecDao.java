package com.hrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.hrms.bean.Recruit;
import com.hrms.util.DateBaseUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class RecDao {
	DateBaseUtil dbutil;
	Connection conn=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	
	public RecDao(){
		dbutil=new DateBaseUtil();
	}
	
	/**
	 * addDep() - 用于新增部门信息
	 * @param depid
	 * @param dep
	 * @param depct
	 * @param depre
	 */
	public void addRec(Integer recruitid, String name, String sex, String recruittype, 
			String education, String workexp, String delainfo){
		String sql="insert into hrrecruit values(?,?,?,?,?,?,?)";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, recruitid);
			pstat.setString(2, name);
			pstat.setString(3, sex);
			pstat.setString(4, recruittype);
			pstat.setString(5, education);
			pstat.setString(6, workexp);
			pstat.setString(7, delainfo);
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
	public ArrayList<Recruit> getRecruit(){
		ArrayList<Recruit> recs=new ArrayList<Recruit>();
		Recruit rec=null;
		String sql="select * from hrrecruit";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()){
				rec=new Recruit(rs.getInt("recruitid"),rs.getString("name"),rs.getString("sex"),rs.getString("recruittype")
						,rs.getString("education"),rs.getString("workexp"),rs.getString("detainfo"),rs.getInt("status"));
				recs.add(rec);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return recs;
	}
	/**
	 * updateStaById() - 用于修改部门信息
	 * @param staid
	 * @param stana
	 */
	public void updateRecById(Integer recruitid,Integer status) {
		String sql="update hrrecruit set status=? where recruitid=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, recruitid);
			pstat.setInt(2, status);
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
	public void removeRecById(Integer recruitid){
		String sql="delete from hrrecruit where recruitid=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, recruitid);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}

}