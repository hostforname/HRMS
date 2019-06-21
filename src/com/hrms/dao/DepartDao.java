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
	public void updateDepById(Integer depid, String dep, String depct, String depre) {
		String sql="update hrdepartment set department=?,createtime=?,remarks=? where departmentid=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, dep);
			pstat.setString(2, depct);
			pstat.setString(3, depre);
			pstat.setInt(4, depid);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}		
	}

}
