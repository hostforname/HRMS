package com.hrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.hrms.bean.Department;
import com.hrms.util.DateBaseUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DepartDao {
	DateBaseUtil dbutil;
	Connection conn=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	
	public DepartDao(){
		dbutil=new DateBaseUtil();
	}
	
	/**
	 * addDep() - 用于新增部门信息
	 * @param depid
	 * @param dep
	 * @param depct
	 * @param depre
	 */
	public void addDep(Integer depid, String dep,
			String depre){
		String sql="insert into hrdepartment(departmentid,department,remarks) values(?,?,?)";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, depid);
			pstat.setString(2, dep);
			pstat.setString(3, depre);
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
	public ArrayList<Department> getDepartment(){
		ArrayList<Department> departs=new ArrayList<Department>();
		Department depart=null;
		String sql="select * from hrdepartment";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()){
				depart=new Department(rs.getInt("departmentid"),rs.getString("department"),rs.getDate("createtime"),rs.getString("remarks"));
				departs.add(depart);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return departs;
	}
	/**
	 * updateDepById() - 用于修改部门信息
	 * @param depid
	 * @param name
	 * @param depct
	 * @param depre
	 */
	public void updateDepById(Integer depid, String dep, String depre) {
		String sql="update hrdepartment set department=?,remarks=? where departmentid=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, dep);
			pstat.setString(2, depre);
			pstat.setInt(3, depid);
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
	public void removeDepById(Integer depid){
		String sql="delete from hrdepartment where departmentid=?";
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
