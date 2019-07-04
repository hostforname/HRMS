package com.hrms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hrms.bean.User;
import com.hrms.util.DateBaseUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDao {
	DateBaseUtil dbutil;
	Connection conn=null;
	PreparedStatement pstat=null;
	ResultSet rs=null;
	
	public UserDao(){
		dbutil=new DateBaseUtil();
	}
	
	/**
	 * isLogin(String username, String userwd) - 判断用户登录
	 * @param username - 用户名
	 * @param userpwd - 密码
	 * @return true[登陆成功]/false[登陆失败]
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
	 * getUser() - 获取数据库表中所有管理员信息
	 * @return - ArrayList<User> uses
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
	 * addUser() - 增加管理员信息
	 * @param username
	 * @param userpwd
	 */
	public void addUser(String username, String userpwd) {
		String sql="insert into hruser(username,userpwd) values(?,?)";
		conn=dbutil.getConnection();
		try{
			pstat=(PreparedStatement) conn.prepareStatement(sql);
			pstat.setString(1, username);
			pstat.setString(2, userpwd);
			pstat.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			dbutil.closeConnection(conn, pstat, rs);
		}
	}
	
	/**
	 * removeUserById() - 通过id来移除管理员信息
	 * @param useid
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

	/**
	 * updatePwd() 通过用户名和密码来更新新密码
	 * @param name
	 * @param opwd
	 * @param npwd
	 */
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
