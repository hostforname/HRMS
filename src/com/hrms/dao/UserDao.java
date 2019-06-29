package com.hrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hrms.bean.User;
import com.hrms.util.DateBaseUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class UserDao {
	DateBaseUtil dbutil;
	Connection conn=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	
	public UserDao(){
		dbutil=new DateBaseUtil();
	}
	
	/**
	 * isLogin(String username, String userwd) - �ж��û���¼
	 * @param username - �û���
	 * @param userpwd - ����
	 * @return true[��½�ɹ�]/false[��½ʧ��]
	 */
	public boolean isLogin(String username, String userpwd){
		String sql="select * from hruser where username=? and userpwd=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, username);
			pstat.setString(2, userpwd);
			rs=pstat.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat, rs);
		}
		return false;
	}
	
	/**
	 * getEmps() - ��ȡ���ݿ��������Ա����Ϣ
	 * @return - ArrayList<Emp> emps
	 */
	public ArrayList<User> getUser(){
		ArrayList<User> uses=new ArrayList<User>();
		User use=null;
		String sql="select * from hruser";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			while(rs.next()){
				use=new User(rs.getInt("userid"), rs.getString("username"), rs.getString("userpwd"));
				uses.add(use);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat,rs);
		}
		return uses;
	}
	
	/**
	 * isLogin(String username, String userwd) - �������û�
	 * @param username - �û���
	 * @param userwd - ����
	 */
	public void addUser(String username, String userpwd) {
		String sql="insert into hruser(username,userpwd) values(?,?)";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, username);
			pstat.setString(2, userpwd);
			int result=pstat.executeUpdate();
			//System.out.println("���ӳɹ�"+result);		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat, rs);
		}
	}
	
	/**
	 * removeDepById(Integer id) - ����ID�Ƴ�Ա����Ϣ
	 * @param id
	 */
	public void removeUserById(Integer useid){
		String sql="delete from hruser where userid=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setInt(1, useid);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}

	public void updatePwd(String name, String opwd, String npwd) {
		String sql="update hruser set userpwd=? where username=? and userpwd=?";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, npwd);
			pstat.setString(2, name);
			pstat.setString(3, opwd);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat);
		}
	}
}
