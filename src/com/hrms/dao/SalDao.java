package com.hrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hrms.bean.Salary;
import com.hrms.util.DateBaseUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class SalDao {
	DateBaseUtil dbutil;
	Connection conn=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	
	public SalDao(){
		dbutil=new DateBaseUtil();
	}
	
	/**
	 * addDep() - 用于新增部门信息
	 * @param depid
	 * @param dep
	 * @param depct
	 * @param depre
	 */
	public void addSal(Integer staid,String stana,String salcu,Integer salba, Integer salov, 
			Integer saldu,Integer salat,Integer salab,Integer salin){
		String sql="insert into hrsalary values(?,?,?,?,?,?,?,?,?)";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, staid);
			pstat.setString(2, stana);
			pstat.setString(3, salcu);
			pstat.setInt(4, salba);
			pstat.setInt(5, salov);
			pstat.setInt(6, saldu);
			pstat.setInt(7, salat);
			pstat.setInt(8, salab);
			pstat.setInt(9, salin);
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
	public ArrayList<Salary> getSalary(){
		ArrayList<Salary> sals=new ArrayList<Salary>();
		Salary sal=null;
		String sql="select staffid,staffname,left(curmonth,7),basepay,overtimepay,duration,attpay,abspay,inspay from hrsalary";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()){
				sal=new Salary(rs.getInt("staffid"),rs.getString("staffname"),rs.getString("left(curmonth,7)"),rs.getInt("basepay"),rs.getInt("overtimepay")
						,rs.getInt("duration"),rs.getInt("attpay"),rs.getInt("abspay"),rs.getInt("inspay"));
				sals.add(sal);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return sals;
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
	 * removeDepById(Integer id) - 根据ID移除员工信息
	 * @param id
	 */
	public void removeSal(Integer staid,String salcu){
		String sql="delete from hrsalary where staffid=? and curmonth like ?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, staid);
			pstat.setString(2, salcu+'%');
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}

}