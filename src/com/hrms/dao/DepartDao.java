package com.hrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	 * addDep() - ��������������Ϣ
	 * @param depid
	 * @param dep
	 * @param depct
	 * @param depre 
	 */
	public void addDep(String dep,
			String depre){
		String sql="insert into hrdepartment(department,remarks) values(?,?)";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, dep);
			pstat.setString(2, depre);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}
	
	/**
	 * getDepartment() - ��ȡ���ݿ�������в�����Ϣ
	 * @return - ArrayList<Department> deps
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
		}finally{
			dbutil.closeConnection(conn, pstat,rs);
		}
		return departs;
	}
	
	/**
	 * getDepart() - ��ȡ���ݱ���еĲ���������Ϣ
	 * @return - ArrayList<Department> departs
	 */
	public ArrayList<Department> getDepart(){
		ArrayList<Department> departs=new ArrayList<Department>();
		Department depart=null;
		String sql="select department from hrdepartment";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()){
				depart=new Department(rs.getString("department"));
				departs.add(depart);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat,rs);
		}
		return departs;
	}
	/**
	 * updateDepById() - �����޸Ĳ�����Ϣ
	 * @param depid
	 * @param name
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
	 * removeDepById(Integer id) - ����ID�Ƴ�������Ϣ
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
	
	/**
	 * getNums(String department) - ��Ա�������ͳ�ƻ��һ����������
	 * @param department
	 * @return - nums
	 */
	public Integer getNums(String department) {
		String sql="select count(*) as nums from hrstaff where department=?";
		conn=dbutil.getConnection();
		Integer nums=0;
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, department);
			rs=pstat.executeQuery();
			//��rs�������ȡֵ֮ǰ��Ҫ���жϵ�����û�в鵽��¼
			if(rs.next()) {
				nums=rs.getInt("nums");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat,rs);
		}
		return nums;
	}

}
